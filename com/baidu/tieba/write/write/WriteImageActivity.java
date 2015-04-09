package com.baidu.tieba.write.write;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] bOT = null;
    private RadioButton bPc;
    private RadioButton bPd;
    private LinearLayout bPn;
    private HashMap<String, Bitmap> bPp;
    private HashMap<String, ImageView> bPq;
    private View bPr;
    private View cyE;
    private View cyF;
    private String cyJ;
    private int requestCode;
    private ImageView atD = null;
    private Bitmap mBitmap = null;
    private TextView cwP = null;
    private View LO = null;
    private HorizontalScrollView bOZ = null;
    private ProgressBar mProgress = null;
    private ch cyG = null;
    private cb cyH = null;
    private RadioGroup MK = null;
    private LinearLayout bPe = null;
    private LinearLayout bPf = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap bPh = null;
    private ci cyI = null;
    private int bPj = 0;
    private int bPk = 0;
    private int mDisplaySize = 0;
    private boolean bPl = true;
    private String bPm = null;
    private boolean bPo = false;
    private boolean bJy = false;
    private final Handler mHandler = new Handler();
    private final Object cyK = new Object();
    private final View.OnClickListener cyL = new bt(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.f.gz().ag("motu_sdk") == 1 || PluginPackageManager.ls().br(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.bPl = false;
        } else {
            this.bPl = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(com.baidu.tieba.w.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.cyJ = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.bPl) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.bJy = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.be.sY().te(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.be.sY().te(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        bOT = getResources().getStringArray(com.baidu.tieba.q.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cyG != null) {
            this.cyG.cancel();
        }
        this.atD.setImageDrawable(null);
        acZ();
    }

    private void acZ() {
        synchronized (this.cyK) {
            if (this.bPq != null) {
                for (Map.Entry<String, ImageView> entry : this.bPq.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.bPq.clear();
                this.bPq = null;
            }
            if (this.bPp != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.bPp.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.bPp.clear();
                this.bPp = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cyG != null) {
            this.cyG.cancel();
        }
        this.cyG = new ch(this, null);
        this.cyG.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.bPh != null && !this.bPh.isRecycled()) {
            this.bPh.recycle();
            this.bPh = null;
        }
        if (this.cyG != null) {
            this.cyG.cancel();
            this.cyG = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cyI);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cyL.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.LO);
        com.baidu.tbadk.core.util.ba.j(this.mNavigationBar, com.baidu.tieba.s.alpha80_black);
        getLayoutMode().h(this.cyE);
        getLayoutMode().h(this.mTitleText);
        this.cyF.setBackgroundResource(com.baidu.tieba.u.title_icon_bg_for_image);
        if (this.cyF.isEnabled()) {
            this.cwP.setTextColor(getResources().getColor(com.baidu.tieba.s.navi_done_text));
        } else {
            this.cwP.setTextColor(getResources().getColor(com.baidu.tieba.s.navi_done_text_d));
        }
    }

    private void initUI() {
        this.LO = findViewById(com.baidu.tieba.v.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mProgress.setVisibility(8);
        this.atD = (ImageView) findViewById(com.baidu.tieba.v.image);
        this.atD.setOnClickListener(new bu(this));
        if (this.mBitmap != null) {
            this.atD.setImageBitmap(this.mBitmap);
        }
        this.bOZ = (HorizontalScrollView) findViewById(com.baidu.tieba.v.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.cyE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bv(this));
        this.cyF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.image_activity_save_button, (View.OnClickListener) null);
        this.cyF.setOnClickListener(new bw(this));
        this.cwP = (TextView) this.cyF.findViewById(com.baidu.tieba.v.save);
        if (TextUtils.isEmpty(this.cyJ)) {
            if (this.bJy || this.requestCode != 12003) {
                this.cwP.setText(getPageContext().getString(com.baidu.tieba.y.done));
            } else {
                this.cwP.setText(getPageContext().getString(com.baidu.tieba.y.delete));
            }
        } else {
            this.cwP.setText(this.cyJ);
        }
        this.bPn = (LinearLayout) findViewById(com.baidu.tieba.v.filters);
        this.bPj = com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.beautify));
        this.bPf = (LinearLayout) findViewById(com.baidu.tieba.v.beautify_rotate);
        this.bPe = (LinearLayout) findViewById(com.baidu.tieba.v.rotate);
        this.bPc = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.bPd = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        this.MK = (RadioGroup) findViewById(com.baidu.tieba.v.beautify_tabs);
        bx bxVar = new bx(this);
        this.bPc.setOnCheckedChangeListener(bxVar);
        this.bPd.setOnCheckedChangeListener(bxVar);
        this.bPc.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.v.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.v.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.v.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.v.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        by byVar = new by(this);
        button.setOnClickListener(byVar);
        button2.setOnClickListener(byVar);
        button3.setOnClickListener(byVar);
        button4.setOnClickListener(byVar);
        this.bPf.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.bPl) {
            this.bPd.setPadding(0, this.bPd.getPaddingTop(), this.bPd.getPaddingRight(), this.bPd.getPaddingBottom());
            this.bPd.setChecked(true);
            this.bOZ.setVisibility(8);
            this.bPc.setVisibility(8);
            this.MK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW(String str) {
        if (this.cyH != null) {
            this.cyH.cancel();
        }
        this.cyH = new cb(this, null);
        this.cyH.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jl(String str) {
        try {
            com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_PIC_DIR, str, this.bPh, 90);
            this.atD.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.bPh, i);
            if (d != null && com.baidu.tbadk.core.util.o.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.bPk));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String[] strArr) {
        if (this.bPp != null && strArr != null) {
            this.bPn.removeAllViews();
            this.bPf.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.dN(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bz(this, substring, i2));
                    this.bPr = imageView2;
                } else {
                    imageView2.setOnClickListener(new ca(this, substring, i2));
                }
                this.bPn.addView(inflate2);
                synchronized (this.cyK) {
                    this.bPq.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            hX(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.bPm != null && (imageView = this.bPq.get(this.bPm)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.bPj, this.bPj, this.bPj, this.bPj);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.bPq != null) {
                ImageView imageView2 = this.bPq.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                    imageView2.setPadding(this.bPj, this.bPj, this.bPj, this.bPj);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.bPm = str;
            }
        }
    }

    private void regReceiver() {
        this.cyI = new ci(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cyI, intentFilter);
    }
}
