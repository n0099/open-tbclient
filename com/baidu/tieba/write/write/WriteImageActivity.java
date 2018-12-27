package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.FiltersView;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.e;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] gvO = null;
    private int eZJ;
    private RadioButton gwc;
    private RadioButton gwd;
    private LinearLayout gwn;
    private HashMap<String, Bitmap> gwp;
    private HashMap<String, ImageView> gwq;
    private View gwr;
    private View icc;
    private View icd;
    private String ich;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView bAS = null;
    private View mParent = null;
    private HorizontalScrollView gvY = null;
    private ProgressBar mProgress = null;
    private b ice = null;
    private a icf = null;
    private RadioGroup cyS = null;
    private LinearLayout gwe = null;
    private LinearLayout gwf = null;
    private TextView dwu = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap gwh = null;
    private c icg = null;
    private int gwj = 0;
    private int gwk = 0;
    private int mDisplaySize = 0;
    private boolean gwl = true;
    private String gwm = null;
    private boolean gwo = false;
    private boolean gbg = false;
    private final Handler mHandler = new Handler();
    private final Object ici = new Object();
    private final View.OnClickListener icj = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.gbg) {
                if (WriteImageActivity.this.eZJ == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.gwo && WriteImageActivity.this.gwh != null && !WriteImageActivity.this.gwh.isRecycled()) {
                            String str = NgWebViewInitHelper.INIT_BWEBKIT_APPID + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.xU(str)) {
                                intent.putExtra("change", true);
                                intent.putExtra("file_name", str);
                            } else {
                                intent.putExtra("change", false);
                            }
                        } else {
                            intent.putExtra("change", false);
                        }
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        return;
                    }
                } else {
                    WriteImageActivity.this.setResult(0, new Intent());
                }
            } else {
                WriteImageActivity.this.setResult(0, new Intent());
            }
            WriteImageActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.iQ().aO("motu_sdk") == 1 || PluginPackageManager.na().cc(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gwl = false;
        } else {
            this.gwl = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(e.h.write_image_activity);
        Intent intent = getIntent();
        this.eZJ = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.ich = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.gwl) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.gbg = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.eZJ == 12002 || this.eZJ == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.eZJ, intent.getData(), aq.DR().DX(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.eZJ, null, aq.DR().DX(), this.mDisplaySize, stringExtra);
            }
            aOx();
        } else {
            initUI();
            initData();
        }
        gvO = getResources().getStringArray(e.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ice != null) {
            this.ice.cancel();
        }
        this.mImage.setImageDrawable(null);
        bpM();
    }

    private void bpM() {
        synchronized (this.ici) {
            if (this.gwq != null) {
                for (Map.Entry<String, ImageView> entry : this.gwq.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.gwq.clear();
                this.gwq = null;
            }
            if (this.gwp != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.gwp.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.gwp.clear();
                this.gwp = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ice != null) {
            this.ice.cancel();
        }
        this.ice = new b();
        this.ice.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        WriteImageActivityConfig.isActivityInStack = false;
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gwh != null && !this.gwh.isRecycled()) {
            this.gwh.recycle();
            this.gwh = null;
        }
        if (this.ice != null) {
            this.ice.cancel();
            this.ice = null;
        }
        this.mProgress.setVisibility(8);
        if (this.eZJ == 12002 || this.eZJ == 12001) {
            unregisterReceiver(this.icg);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.icj.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mParent);
        al.j(this.mNavigationBar, e.d.common_color_10222);
        al.c(this.dwu, e.d.cp_cont_g, 1);
        if (this.icd.isEnabled()) {
            this.bAS.setTextColor(getResources().getColor(e.d.navi_done_text));
        } else {
            this.bAS.setTextColor(getResources().getColor(e.d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        al.a((ImageView) ((ViewGroup) this.icc).getChildAt(0), e.f.icon_topbar_return_s, e.f.icon_topbar_return_s);
    }

    private void initUI() {
        this.mParent = findViewById(e.g.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.gwf.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.gwf.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.gvY = (HorizontalScrollView) findViewById(e.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.icc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.gbg) {
                    if (WriteImageActivity.this.eZJ == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.gwo && WriteImageActivity.this.gwh != null && !WriteImageActivity.this.gwh.isRecycled()) {
                                String str = NgWebViewInitHelper.INIT_BWEBKIT_APPID + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.xU(str)) {
                                    intent.putExtra("change", true);
                                    intent.putExtra("file_name", str);
                                } else {
                                    intent.putExtra("change", false);
                                }
                            } else {
                                intent.putExtra("change", false);
                            }
                            WriteImageActivity.this.setResult(-1, intent);
                        } else {
                            return;
                        }
                    } else {
                        WriteImageActivity.this.setResult(0, new Intent());
                    }
                } else {
                    WriteImageActivity.this.setResult(0, new Intent());
                }
                WriteImageActivity.this.finish();
            }
        });
        this.icd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, (View.OnClickListener) null);
        this.icd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.gbg) {
                    if (WriteImageActivity.this.eZJ == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.gwo) {
                            if (WriteImageActivity.this.gwh != null && !WriteImageActivity.this.gwh.isRecycled()) {
                                String str = NgWebViewInitHelper.INIT_BWEBKIT_APPID + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.xU(str)) {
                                    intent2.putExtra("change", true);
                                    intent2.putExtra("file_name", str);
                                } else {
                                    intent2.putExtra("change", false);
                                }
                            } else {
                                intent2.putExtra("change", false);
                            }
                        } else {
                            intent2.setData(WriteImageActivity.this.getIntent().getData());
                            WriteImageActivity.this.setResult(-1, intent2);
                        }
                        WriteImageActivity.this.setResult(-1, intent2);
                    }
                    WriteImageActivity.this.finish();
                    return;
                }
                Intent intent3 = new Intent();
                if (WriteImageActivity.this.gwo && WriteImageActivity.this.gwh != null && !WriteImageActivity.this.gwh.isRecycled()) {
                    String str2 = NgWebViewInitHelper.INIT_BWEBKIT_APPID + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.xU(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.bAS = (TextView) this.icd.findViewById(e.g.save);
        if (TextUtils.isEmpty(this.ich)) {
            if (this.gbg || this.eZJ != 12003) {
                this.bAS.setText(getPageContext().getString(e.j.done));
            } else {
                this.bAS.setText(getPageContext().getString(e.j.delete));
            }
        } else {
            this.bAS.setText(this.ich);
        }
        this.gwn = (LinearLayout) findViewById(e.g.filters);
        this.gwj = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.dwu = this.mNavigationBar.setTitleText(getPageContext().getString(e.j.beautify));
        this.gwf = (LinearLayout) findViewById(e.g.beautify_rotate);
        this.gwe = (LinearLayout) findViewById(e.g.rotate);
        this.gwc = (RadioButton) findViewById(e.g.beautify_btn);
        this.gwd = (RadioButton) findViewById(e.g.rotate_btn);
        this.cyS = (RadioGroup) findViewById(e.g.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.gwc) {
                        WriteImageActivity.this.gvY.setVisibility(0);
                        WriteImageActivity.this.gwe.setVisibility(8);
                        WriteImageActivity.this.dwu.setText(WriteImageActivity.this.getPageContext().getString(e.j.beautify));
                    } else if (compoundButton == WriteImageActivity.this.gwd) {
                        WriteImageActivity.this.gvY.setVisibility(8);
                        WriteImageActivity.this.gwe.setVisibility(0);
                        WriteImageActivity.this.dwu.setText(WriteImageActivity.this.getPageContext().getString(e.j.rotate));
                    }
                }
            }
        };
        this.gwc.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gwd.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gwc.setChecked(true);
        Button button = (Button) findViewById(e.g.rotate_left);
        Button button2 = (Button) findViewById(e.g.rotate_right);
        Button button3 = (Button) findViewById(e.g.rotate_left_right);
        Button button4 = (Button) findViewById(e.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.gwh != null) && view.getTag() != null) {
                        WriteImageActivity.this.gwo = false;
                        WriteImageActivity.this.xT(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.gwf.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.gwl) {
            this.gwd.setPadding(0, this.gwd.getPaddingTop(), this.gwd.getPaddingRight(), this.gwd.getPaddingBottom());
            this.gwd.setChecked(true);
            this.gvY.setVisibility(8);
            this.gwc.setVisibility(8);
            this.cyS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xT(String str) {
        if (this.icf != null) {
            this.icf.cancel();
        }
        this.icf = new a();
        this.icf.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap ax = com.baidu.tbadk.core.util.l.ax(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && ax != null && !ax.isRecycled()) {
                        ax.recycle();
                        return null;
                    }
                    if (ax != null) {
                        int dip2px = l.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.gwl) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(ax, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(ax)) {
                                    ax = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(ax, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.ici) {
                                        WriteImageActivity.this.gwp = new HashMap();
                                        WriteImageActivity.this.gwq = new HashMap();
                                        WriteImageActivity.this.gwp.put("normal", roundedCornerBitmap);
                                    }
                                    return ax;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return ax;
                } catch (Exception e) {
                    bitmap = ax;
                    e = e;
                    e.printStackTrace();
                    BdLog.e(e.toString());
                    return bitmap;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.icd.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.ice = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.icd.setEnabled(true);
            WriteImageActivity.this.ice = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.gwl) {
                    WriteImageActivity.this.D(WriteImageActivity.gvO);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xU(String str) {
        try {
            com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_PIC_DIR, str, this.gwh, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.gwh, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.l.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.gwk));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String[] strArr) {
        if (this.gwp != null && strArr != null) {
            this.gwn.removeAllViews();
            this.gwf.setVisibility(0);
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
                imageView2.setImageResource(FiltersView.hf(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                                WriteImageActivity.this.mImage.setImageBitmap(WriteImageActivity.this.mBitmap);
                                WriteImageActivity.this.gwo = false;
                                WriteImageActivity.this.tF(substring);
                                WriteImageActivity.this.gwk = i2;
                            }
                        }
                    });
                    this.gwr = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0 && !substring.equals(WriteImageActivity.this.gwm)) {
                                WriteImageActivity.this.xT(substring);
                                WriteImageActivity.this.tF(substring);
                                WriteImageActivity.this.gwk = i2;
                            }
                        }
                    });
                }
                this.gwn.addView(inflate2);
                synchronized (this.ici) {
                    this.gwq.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            tF("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tF(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.gwm != null && (imageView = this.gwq.get(this.gwm)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gwj, this.gwj, this.gwj, this.gwj);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.gwq != null) {
                ImageView imageView2 = this.gwq.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(e.f.bg_choose_filter);
                    imageView2.setPadding(this.gwj, this.gwj, this.gwj, this.gwj);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.gwm = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String gww;
        private Boolean gwx;
        private Boolean gwy;

        private a() {
            this.gwx = false;
            this.gwy = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.gwl) {
                PluginPackageManager.PluginStatus cc = PluginPackageManager.na().cc(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && cc != PluginPackageManager.PluginStatus.NROMAL) {
                    if (cc == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.tF("normal");
                            }
                        }, 500L);
                        WriteImageActivity.this.showToast(e.j.plugin_config_not_found);
                        return;
                    } else if (cc == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.na().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.2
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.tF("normal");
                            }
                        }, 500L);
                        cancel();
                        return;
                    } else if (cc == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.d.a.a(WriteImageActivity.this.getPageContext(), e.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
                                aVar.dismiss();
                            }
                        }, new a.b() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        });
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.5
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.tF("normal");
                            }
                        }, 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.icd.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.gww = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.gwh == null) {
                return null;
            }
            if (this.gww.equals("0") || this.gww.equals("1")) {
                this.gwx = true;
            } else if (this.gww.equals("2") || this.gww.equals("3")) {
                this.gwy = true;
            }
            if (this.gwx.booleanValue() || this.gwy.booleanValue()) {
                if (WriteImageActivity.this.gwh == null || WriteImageActivity.this.gwh.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.gwh.copy(WriteImageActivity.this.gwh.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.gwx.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.gww));
                } else if (this.gwy.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.gww));
                } else {
                    MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                    if (motuPlugin != null) {
                        this.bitmap = motuPlugin.createOneKeyFilterAndApply(WriteImageActivity.this.getPageContext().getPageActivity(), this.gww, this.bitmap);
                    }
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.gwh != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.icd.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.icd.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.gwo = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.gwx.booleanValue() || this.gwy.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.gwx.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.gww));
                    } else if (this.gwy.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.gww));
                    }
                }
                if (WriteImageActivity.this.gwh != null && !WriteImageActivity.this.gwh.isRecycled()) {
                    WriteImageActivity.this.gwh.recycle();
                }
                WriteImageActivity.this.gwh = bitmap;
            }
        }
    }

    private void aOx() {
        this.icg = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.icg, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WriteImageActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                WriteImageActivity.this.initData();
                return;
            }
            WriteImageActivity.this.showToast(intent.getStringExtra(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            if (WriteImageActivity.this.icd != null) {
                WriteImageActivity.this.icd.setEnabled(false);
            }
        }
    }
}
