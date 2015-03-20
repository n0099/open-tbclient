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
    private static String[] bOD = null;
    private RadioButton bOM;
    private RadioButton bON;
    private LinearLayout bOX;
    private HashMap<String, Bitmap> bOZ;
    private HashMap<String, ImageView> bPa;
    private View bPb;
    private View cyi;
    private View cyj;
    private String cyn;
    private int requestCode;
    private ImageView atv = null;
    private Bitmap mBitmap = null;
    private TextView cww = null;
    private View LM = null;
    private HorizontalScrollView bOJ = null;
    private ProgressBar mProgress = null;
    private ch cyk = null;
    private cb cyl = null;
    private RadioGroup MI = null;
    private LinearLayout bOO = null;
    private LinearLayout bOP = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap bOR = null;
    private ci cym = null;
    private int bOT = 0;
    private int bOU = 0;
    private int mDisplaySize = 0;
    private boolean bOV = true;
    private String bOW = null;
    private boolean bOY = false;
    private boolean bJj = false;
    private final Handler mHandler = new Handler();
    private final Object cyo = new Object();
    private final View.OnClickListener cyp = new bt(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.f.gz().ag("motu_sdk") == 1 || PluginPackageManager.ls().br(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.bOV = false;
        } else {
            this.bOV = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(com.baidu.tieba.w.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.cyn = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.bOV) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.bJj = true;
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
        bOD = getResources().getStringArray(com.baidu.tieba.q.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cyk != null) {
            this.cyk.cancel();
        }
        this.atv.setImageDrawable(null);
        acK();
    }

    private void acK() {
        synchronized (this.cyo) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cyk != null) {
            this.cyk.cancel();
        }
        this.cyk = new ch(this, null);
        this.cyk.execute(new Object[0]);
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
        if (this.bOR != null && !this.bOR.isRecycled()) {
            this.bOR.recycle();
            this.bOR = null;
        }
        if (this.cyk != null) {
            this.cyk.cancel();
            this.cyk = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cym);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cyp.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.LM);
        com.baidu.tbadk.core.util.ba.j(this.mNavigationBar, com.baidu.tieba.s.alpha80_black);
        getLayoutMode().h(this.cyi);
        getLayoutMode().h(this.mTitleText);
        this.cyj.setBackgroundResource(com.baidu.tieba.u.title_icon_bg_for_image);
        if (this.cyj.isEnabled()) {
            this.cww.setTextColor(getResources().getColor(com.baidu.tieba.s.navi_done_text));
        } else {
            this.cww.setTextColor(getResources().getColor(com.baidu.tieba.s.navi_done_text_d));
        }
    }

    private void initUI() {
        this.LM = findViewById(com.baidu.tieba.v.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mProgress.setVisibility(8);
        this.atv = (ImageView) findViewById(com.baidu.tieba.v.image);
        this.atv.setOnClickListener(new bu(this));
        if (this.mBitmap != null) {
            this.atv.setImageBitmap(this.mBitmap);
        }
        this.bOJ = (HorizontalScrollView) findViewById(com.baidu.tieba.v.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.cyi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bv(this));
        this.cyj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.image_activity_save_button, (View.OnClickListener) null);
        this.cyj.setOnClickListener(new bw(this));
        this.cww = (TextView) this.cyj.findViewById(com.baidu.tieba.v.save);
        if (TextUtils.isEmpty(this.cyn)) {
            if (this.bJj || this.requestCode != 12003) {
                this.cww.setText(getPageContext().getString(com.baidu.tieba.y.done));
            } else {
                this.cww.setText(getPageContext().getString(com.baidu.tieba.y.delete));
            }
        } else {
            this.cww.setText(this.cyn);
        }
        this.bOX = (LinearLayout) findViewById(com.baidu.tieba.v.filters);
        this.bOT = com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.beautify));
        this.bOP = (LinearLayout) findViewById(com.baidu.tieba.v.beautify_rotate);
        this.bOO = (LinearLayout) findViewById(com.baidu.tieba.v.rotate);
        this.bOM = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.bON = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        this.MI = (RadioGroup) findViewById(com.baidu.tieba.v.beautify_tabs);
        bx bxVar = new bx(this);
        this.bOM.setOnCheckedChangeListener(bxVar);
        this.bON.setOnCheckedChangeListener(bxVar);
        this.bOM.setChecked(true);
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
        this.bOP.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.bOV) {
            this.bON.setPadding(0, this.bON.getPaddingTop(), this.bON.getPaddingRight(), this.bON.getPaddingBottom());
            this.bON.setChecked(true);
            this.bOJ.setVisibility(8);
            this.bOM.setVisibility(8);
            this.MI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT(String str) {
        if (this.cyl != null) {
            this.cyl.cancel();
        }
        this.cyl = new cb(this, null);
        this.cyl.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ji(String str) {
        try {
            com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_PIC_DIR, str, this.bOR, 90);
            this.atv.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.bOR, i);
            if (d != null && com.baidu.tbadk.core.util.o.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.bOU));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String[] strArr) {
        if (this.bOZ != null && strArr != null) {
            this.bOX.removeAllViews();
            this.bOP.setVisibility(0);
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
                    imageView2.setOnClickListener(new bz(this, substring, i2));
                    this.bPb = imageView2;
                } else {
                    imageView2.setOnClickListener(new ca(this, substring, i2));
                }
                this.bOX.addView(inflate2);
                synchronized (this.cyo) {
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
            if (this.bOW != null && (imageView = this.bPa.get(this.bOW)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.bOT, this.bOT, this.bOT, this.bOT);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.bPa != null) {
                ImageView imageView2 = this.bPa.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                    imageView2.setPadding(this.bOT, this.bOT, this.bOT, this.bOT);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.bOW = str;
            }
        }
    }

    private void regReceiver() {
        this.cym = new ci(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cym, intentFilter);
    }
}
