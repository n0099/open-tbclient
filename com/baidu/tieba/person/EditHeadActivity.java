package com.baidu.tieba.person;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bOF;
    private View bOG;
    private RadioButton bOM;
    private RadioButton bON;
    private LinearLayout bOX;
    private HashMap<String, Bitmap> bOZ;
    private HashMap<String, ImageView> bPa;
    private View bPb;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String bOC = "change";
    public static String FILE_NAME = "file_name";
    private static String[] bOD = null;
    private EditHeadsImageView bOE = null;
    private Bitmap mBitmap = null;
    private int bnp = 0;
    private Button bOH = null;
    private Button bOI = null;
    private HorizontalScrollView bOJ = null;
    private ProgressBar mProgress = null;
    private q bOK = null;
    private n bOL = null;
    private LinearLayout bOO = null;
    private LinearLayout bOP = null;
    private s bOQ = null;
    private TextView mTitle = null;
    private Bitmap bOR = null;
    private r bOS = null;
    private int bOT = 0;
    private int bOU = 0;
    private boolean bOV = true;
    private String bOW = null;
    private boolean bOY = false;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.gz().ag("motu_sdk") == 1 || PluginPackageManager.ls().br(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.bOV = false;
        } else {
            this.bOV = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.edit_head_activity);
        Intent intent = getIntent();
        this.bnp = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.be.sY().te());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.be.sY().te(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        bOD = getResources().getStringArray(com.baidu.tieba.q.fiter_name);
        if (this.bOV) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ba.j(this.mNavigationBar, com.baidu.tieba.s.alpha80_black);
        getLayoutMode().h(this.bOF);
        getLayoutMode().h(this.mTitle);
        getLayoutMode().h(this.bOG);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.bOK != null) {
            this.bOK.cancel();
        }
        this.bOE.setImageDrawable(null);
        acK();
    }

    private void acK() {
        if (this.bPa != null) {
            for (Map.Entry<String, ImageView> entry : this.bPa.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.bPa.clear();
            this.bPa = null;
        }
        if (this.bOZ != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.bOZ.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.bOZ.clear();
            this.bOZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.bOK != null) {
            this.bOK.cancel();
        }
        this.bOK = new q(this, null);
        this.bOK.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
        if (accountData != null) {
            TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getBaseContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.bOE.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.bOQ != null) {
            this.bOQ.cancel();
        }
        if (this.bOR != null && !this.bOR.isRecycled()) {
            this.bOR.recycle();
            this.bOR = null;
        }
        if (this.bOK != null) {
            this.bOK.cancel();
            this.bOK = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.bOS);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acL() {
        if (this.bOQ != null) {
            this.bOQ.cancel();
        }
        this.bOQ = new s(this, null);
        this.bOQ.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mProgress.setVisibility(8);
        this.bOE = (EditHeadsImageView) findViewById(com.baidu.tieba.v.image);
        if (this.mBitmap != null) {
            this.bOE.setImageBitmap(this.mBitmap);
        }
        this.bOJ = (HorizontalScrollView) findViewById(com.baidu.tieba.v.filters_layout);
        this.bOF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.bOI = (Button) findViewById(com.baidu.tieba.v.show_button);
        this.bOI.setOnClickListener(new f(this));
        this.bOH = (Button) findViewById(com.baidu.tieba.v.hide_button);
        this.bOH.setVisibility(0);
        this.bOH.setOnClickListener(new g(this));
        this.bOG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.image_activity_save_button, (View.OnClickListener) null);
        this.bOG.setOnClickListener(new h(this));
        this.bOG.setEnabled(false);
        ((TextView) this.bOG.findViewById(com.baidu.tieba.v.save)).setText(com.baidu.tieba.y.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.beautify));
        this.bOX = (LinearLayout) findViewById(com.baidu.tieba.v.filters);
        this.bOT = com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bOP = (LinearLayout) findViewById(com.baidu.tieba.v.beautify_rotate);
        this.bOO = (LinearLayout) findViewById(com.baidu.tieba.v.rotate);
        this.bOM = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.bON = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        j jVar = new j(this);
        this.bOM.setOnCheckedChangeListener(jVar);
        this.bON.setOnCheckedChangeListener(jVar);
        this.bOM.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.v.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.v.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.v.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.v.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        k kVar = new k(this);
        button.setOnClickListener(kVar);
        button2.setOnClickListener(kVar);
        button3.setOnClickListener(kVar);
        button4.setOnClickListener(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT(String str) {
        if (this.bOL != null) {
            this.bOL.cancel();
        }
        this.bOL = new n(this, null);
        this.bOL.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.o.a(null, str, bitmap, 80);
            if (this.bOY) {
                new com.baidu.tbadk.core.util.ay("motu_pic", String.valueOf(this.bOU)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String[] strArr) {
        if (this.bOZ != null && strArr != null) {
            this.bOX.removeAllViews();
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), com.baidu.tieba.w.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.v.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), com.baidu.tieba.w.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.v.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.v.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.dK(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new l(this, substring, i2));
                    this.bPb = imageView2;
                } else {
                    imageView2.setOnClickListener(new m(this, substring, i2));
                }
                this.bOX.addView(inflate2);
                if (this.bPa != null) {
                    this.bPa.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            hU(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.bPa == null) {
                this.bPa = new HashMap<>();
            }
            if (this.bOW != null && (imageView = this.bPa.get(this.bOW)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.bOT, this.bOT, this.bOT, this.bOT);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.bPa.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.u.round_corner);
                imageView2.setPadding(this.bOT, this.bOT, this.bOT, this.bOT);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.bOW = str;
        }
    }

    private void regReceiver() {
        this.bOS = new r(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.bOS, intentFilter);
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
}
