package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.FiltersView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int eOL;
    private String gkJ;
    private ImageView gkM;
    private FrameLayout gkN;
    private View gkO;
    private View gkP;
    private RadioButton gkW;
    private RadioButton gkX;
    private LinearLayout glh;
    private HashMap<String, Bitmap> glj;
    private HashMap<String, ImageView> glk;
    private View gll;
    private TextView glm;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String gkG = "change";
    public static String FILE_NAME = "file_name";
    private static String[] gkI = null;
    private float gkH = 1.0f;
    private EditHeadsImageView gkK = null;
    private EditHeadsImageTopLayerView gkL = null;
    private Bitmap mBitmap = null;
    private int eRk = 0;
    private Button gkQ = null;
    private Button gkR = null;
    private HorizontalScrollView gkS = null;
    private com.baidu.tbadk.core.view.d gkT = null;
    private b gkU = null;
    private a gkV = null;
    private LinearLayout gkY = null;
    private LinearLayout gkZ = null;
    private d gla = null;
    private TextView mTitle = null;
    private Bitmap glb = null;
    private c glc = null;
    private int gld = 0;
    private int gle = 0;
    private boolean glf = true;
    private String glg = null;
    private boolean gli = false;
    private boolean bdM = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.iR().aO("motu_sdk") == 1 || PluginPackageManager.nd().cc(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.glf = false;
        } else {
            this.glf = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.edit_head_activity);
        Intent intent = getIntent();
        this.eRk = intent.getIntExtra("edit_type", 0);
        this.eOL = intent.getIntExtra("request", 0);
        this.bdM = intent.getBooleanExtra("need_upload", true);
        this.gkH = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.gkJ = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.eOL == 12002 || this.eOL == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.eOL, intent.getData(), aq.CG().CM());
            } else {
                TiebaPrepareImageService.StartService(this.eOL, null, aq.CG().CM(), 0, stringExtra);
            }
            aMu();
        } else {
            initUI();
            initData();
        }
        gkI = getResources().getStringArray(e.b.fiter_name);
        if (this.glf) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bnM();
    }

    private void bnM() {
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.gkO);
        getLayoutMode().onModeChanged(this.gkP);
        al.c(this.mTitle, e.d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_topbar_return_s, e.f.icon_topbar_return_s, 0);
        al.c(this.glm, e.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gkU != null) {
            this.gkU.cancel();
        }
        this.gkK.setImageDrawable(null);
        bnN();
    }

    private void bnN() {
        if (this.glk != null) {
            for (Map.Entry<String, ImageView> entry : this.glk.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.glk.clear();
            this.glk = null;
        }
        if (this.glj != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.glj.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.glj.clear();
            this.glj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gkU != null) {
            this.gkU.cancel();
        }
        this.gkU = new b();
        this.gkU.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
        if (accountData != null) {
            TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.gkK.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gla != null) {
            this.gla.cancel();
        }
        if (this.glb != null && !this.glb.isRecycled()) {
            this.glb.recycle();
            this.glb = null;
        }
        if (this.gkU != null) {
            this.gkU.cancel();
            this.gkU = null;
        }
        this.gkT.bj(false);
        if (this.eOL == 12002 || this.eOL == 12001) {
            unregisterReceiver(this.glc);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnO() {
        if (this.gla != null) {
            this.gla.cancel();
        }
        this.gla = new d();
        this.gla.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.gkT = new com.baidu.tbadk.core.view.d(getPageContext());
        this.gkT.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.gkT.bj(false);
            }
        });
        this.gkT.bj(false);
        this.gkL = (EditHeadsImageTopLayerView) findViewById(e.g.image_top_layer);
        this.gkM = (ImageView) findViewById(e.g.preview_image);
        this.gkN = (FrameLayout) findViewById(e.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.gkN.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(e.C0175e.ds74)));
        this.gkK = (EditHeadsImageView) findViewById(e.g.image);
        this.gkK.setCutImageHeightScale(this.gkH);
        if (this.mBitmap != null) {
            this.gkK.setImageBitmap(this.mBitmap);
        }
        this.gkK.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.gkN != null && EditHeadActivity.this.gkN.getVisibility() == 0) {
                    EditHeadActivity.this.gkM.setImageBitmap(EditHeadActivity.this.gkK.lO(false));
                }
            }
        });
        this.gkK.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.gkN != null && EditHeadActivity.this.gkN.getVisibility() == 0) {
                    EditHeadActivity.this.gkM.setImageBitmap(EditHeadActivity.this.gkK.lO(false));
                }
            }
        });
        this.gkS = (HorizontalScrollView) findViewById(e.g.filters_layout);
        this.gkO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.gkR = (Button) findViewById(e.g.show_button);
        this.gkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gkZ.setVisibility(0);
                EditHeadActivity.this.gkR.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.glf) {
                    EditHeadActivity.this.gkX.setPadding(0, EditHeadActivity.this.gkX.getPaddingTop(), EditHeadActivity.this.gkX.getPaddingRight(), EditHeadActivity.this.gkX.getPaddingBottom());
                    EditHeadActivity.this.gkX.setChecked(true);
                    EditHeadActivity.this.gkS.setVisibility(8);
                    EditHeadActivity.this.gkW.setVisibility(8);
                }
            }
        });
        this.gkQ = (Button) findViewById(e.g.hide_button);
        this.gkQ.setVisibility(0);
        this.gkQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gkZ.setVisibility(8);
                EditHeadActivity.this.gkR.setVisibility(0);
            }
        });
        this.gkP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, (View.OnClickListener) null);
        this.gkP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eRk == 0) {
                    if (!EditHeadActivity.this.bdM) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap lO = EditHeadActivity.this.gkK.lO(EditHeadActivity.this.eRk == 0 || EditHeadActivity.this.eRk == 3);
                if (lO != null && EditHeadActivity.this.c(str, lO)) {
                    if (EditHeadActivity.this.eRk == 0) {
                        if (EditHeadActivity.this.bdM) {
                            EditHeadActivity.this.bnO();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.l.eB(str), "head");
                    aVar.Ml();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(e.j.upload_pic_error, false);
                                } else {
                                    PhotoUrlData photoUrlData = new PhotoUrlData();
                                    photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
                                    if (imageUploadResult.picInfo != null) {
                                        if (imageUploadResult.picInfo.bigPic != null) {
                                            photoUrlData.setBigurl(imageUploadResult.picInfo.bigPic.picUrl);
                                        }
                                        if (imageUploadResult.picInfo.smallPic != null) {
                                            photoUrlData.setSmallurl(imageUploadResult.picInfo.smallPic.picUrl);
                                        }
                                        if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                                            photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                                        }
                                    }
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.gkJ)) {
                                        EditHeadActivity.this.c(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                }
                            }
                            EditHeadActivity.this.setResult(-1, intent2);
                            EditHeadActivity.this.finish();
                        }
                    });
                    aVar.ci(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(e.j.uploading));
                }
            }
        });
        this.gkP.setEnabled(false);
        this.glm = (TextView) this.gkP.findViewById(e.g.save);
        this.glm.setText(e.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gkJ)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(e.j.beautify));
        }
        if ("from_photo_live".equals(this.gkJ)) {
            this.mTitle.setText(e.j.choose_picture);
        }
        this.glh = (LinearLayout) findViewById(e.g.filters);
        this.gld = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.gkZ = (LinearLayout) findViewById(e.g.beautify_rotate);
        this.gkY = (LinearLayout) findViewById(e.g.rotate);
        this.gkW = (RadioButton) findViewById(e.g.beautify_btn);
        this.gkX = (RadioButton) findViewById(e.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.gkW) {
                        EditHeadActivity.this.gkS.setVisibility(0);
                        EditHeadActivity.this.gkY.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.gkX) {
                        EditHeadActivity.this.gkS.setVisibility(8);
                        EditHeadActivity.this.gkY.setVisibility(0);
                    }
                }
            }
        };
        this.gkW.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gkX.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gkW.setChecked(true);
        Button button = (Button) findViewById(e.g.rotate_left);
        Button button2 = (Button) findViewById(e.g.rotate_right);
        Button button3 = (Button) findViewById(e.g.rotate_left_right);
        Button button4 = (Button) findViewById(e.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EditHeadActivity.this.gkT.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.glb != null) && view.getTag() != null) {
                        EditHeadActivity.this.gli = false;
                        EditHeadActivity.this.W(view.getTag().toString(), false);
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gkJ)) {
            this.gkN.setVisibility(0);
            this.gkR.setVisibility(8);
            this.gkL.setLinePaintColor(getResources().getColor(e.d.white_alpha50));
            this.gkL.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, boolean z) {
        if (this.gkV != null) {
            this.gkV.cancel();
        }
        this.gkV = new a(z);
        this.gkV.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap au = com.baidu.tbadk.core.util.l.au(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (au.getWidth() > 1800 || au.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(au, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            au.recycle();
                            au = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && au != null && !au.isRecycled()) {
                        au.recycle();
                        return null;
                    }
                    int dip2px = l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.glf) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(au, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), au != resizedBitmap);
                        EditHeadActivity.this.glj = new HashMap();
                        EditHeadActivity.this.glk = new HashMap();
                        EditHeadActivity.this.glj.put("normal", roundedCornerBitmap);
                    }
                    return au;
                } catch (Exception e2) {
                    bitmap = au;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.gkT.bj(true);
            EditHeadActivity.this.gkP.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.gkU = null;
            EditHeadActivity.this.gkT.bj(false);
            EditHeadActivity.this.gkP.setClickable(true);
            EditHeadActivity.this.gkP.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.gkU = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.gkT.bj(false);
            EditHeadActivity.this.gkP.setClickable(true);
            EditHeadActivity.this.gkP.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.gkK.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.gkK.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.glf) {
                    EditHeadActivity.this.B(EditHeadActivity.gkI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.l.a((String) null, str, bitmap, 80);
            if (this.gli) {
                new ag("motu_pic", String.valueOf(this.gle)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String[] strArr) {
        if (this.glj != null && strArr != null) {
            this.glh.removeAllViews();
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(e.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(e.g.filter_text);
            int length = strArr.length;
            int i = 0;
            final int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                final String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(e.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(e.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(FiltersView.gL(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gkT.isShowing()) {
                                EditHeadActivity.this.gkK.j(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.gli = false;
                                EditHeadActivity.this.sX(substring);
                                EditHeadActivity.this.gle = i2;
                            }
                        }
                    });
                    this.gll = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gkT.isShowing() && !substring.equals(EditHeadActivity.this.glg)) {
                                EditHeadActivity.this.W(substring, true);
                                EditHeadActivity.this.sX(substring);
                                EditHeadActivity.this.gle = i2;
                            }
                        }
                    });
                }
                this.glh.addView(inflate2);
                if (this.glk != null) {
                    this.glk.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            sX("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sX(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.glk == null) {
                this.glk = new HashMap<>();
            }
            if (this.glg != null && (imageView = this.glk.get(this.glg)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gld, this.gld, this.gld, this.gld);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.glk.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(e.f.round_corner);
                imageView2.setPadding(this.gld, this.gld, this.gld, this.gld);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.glg = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean glp;
        private String glq;
        private Boolean glr = false;
        private Boolean gls = false;

        public a(boolean z) {
            this.glp = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.glp || bnQ()) {
                EditHeadActivity.this.gkT.bj(true);
                EditHeadActivity.this.gkP.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.glq = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.glb == null) {
                return null;
            }
            if (this.glq.equals("0") || this.glq.equals("1")) {
                this.glr = true;
            } else if (this.glq.equals("2") || this.glq.equals("3")) {
                this.gls = true;
            }
            if (this.glr.booleanValue() || this.gls.booleanValue()) {
                if (EditHeadActivity.this.glb != null) {
                    this.bitmap = EditHeadActivity.this.glb.copy(EditHeadActivity.this.glb.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.glr.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.glq));
            } else if (this.gls.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.glq));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.glq, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bnQ() {
            PluginPackageManager.PluginStatus cc = PluginPackageManager.nd().cc(PluginCenter.NAME_MOTUSDK);
            if (cc == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (cc == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), e.j.plugin_config_not_found);
                return false;
            } else if (cc == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.nd().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (cc == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.d.a.a(EditHeadActivity.this.getPageContext(), e.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
                        aVar.dismiss();
                    }
                }, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.glb != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.gkT.bj(false);
            EditHeadActivity.this.gkP.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.gkT.bj(false);
            EditHeadActivity.this.gkP.setClickable(true);
            EditHeadActivity.this.gkP.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.gli = true;
                if (this.glr.booleanValue() || this.gls.booleanValue()) {
                    EditHeadActivity.this.gkK.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.glr.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.glq));
                    } else if (this.gls.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.glq));
                    }
                } else {
                    EditHeadActivity.this.gkK.j(bitmap);
                }
                if (EditHeadActivity.this.glb != null && !EditHeadActivity.this.glb.isRecycled()) {
                    EditHeadActivity.this.glb.recycle();
                }
                EditHeadActivity.this.glb = bitmap;
            }
        }
    }

    private void aMu() {
        this.glc = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.glc, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            EditHeadActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                EditHeadActivity.this.initData();
                return;
            }
            EditHeadActivity.this.showToast(intent.getStringExtra(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            if (EditHeadActivity.this.gkP != null) {
                EditHeadActivity.this.gkP.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PhotoUrlData photoUrlData) {
        Intent intent = new Intent(EditHeadActivityConfig.ACTION_UPLOAD_SUCCESS);
        intent.putExtra(EditHeadActivityConfig.PIC_INFO, photoUrlData);
        getPageContext().getPageActivity().sendBroadcast(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private x mNetwork;

        private d() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(e.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.fh(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.BY().CX().isRequestSuccess()) {
                    return str;
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.closeLoadingDialog();
            EditHeadActivity.this.gla = null;
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.BY().CX().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(e.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
