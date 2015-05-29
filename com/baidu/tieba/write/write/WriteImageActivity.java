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
    private static String[] bQW = null;
    private RadioButton bRf;
    private RadioButton bRg;
    private LinearLayout bRq;
    private HashMap<String, Bitmap> bRs;
    private HashMap<String, ImageView> bRt;
    private View bRu;
    private View cCW;
    private View cCX;
    private String cDb;
    private int requestCode;
    private ImageView avb = null;
    private Bitmap mBitmap = null;
    private TextView cBg = null;
    private View LG = null;
    private HorizontalScrollView bRc = null;
    private ProgressBar mProgress = null;
    private ci cCY = null;
    private cc cCZ = null;
    private RadioGroup MG = null;
    private LinearLayout bRh = null;
    private LinearLayout bRi = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap bRk = null;
    private cj cDa = null;
    private int bRm = 0;
    private int bRn = 0;
    private int mDisplaySize = 0;
    private boolean bRo = true;
    private String bRp = null;
    private boolean bRr = false;
    private boolean bLE = false;
    private final Handler mHandler = new Handler();
    private final Object cDc = new Object();
    private final View.OnClickListener cDd = new bu(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.f.gD().ai("motu_sdk") == 1 || PluginPackageManager.lM().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.bRo = false;
        } else {
            this.bRo = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(com.baidu.tieba.r.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.cDb = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.bRo) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.bLE = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.bc.tB().tH(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.bc.tB().tH(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        bQW = getResources().getStringArray(com.baidu.tieba.l.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cCY != null) {
            this.cCY.cancel();
        }
        this.avb.setImageDrawable(null);
        adZ();
    }

    private void adZ() {
        synchronized (this.cDc) {
            if (this.bRt != null) {
                for (Map.Entry<String, ImageView> entry : this.bRt.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.bRt.clear();
                this.bRt = null;
            }
            if (this.bRs != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.bRs.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.bRs.clear();
                this.bRs = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cCY != null) {
            this.cCY.cancel();
        }
        this.cCY = new ci(this, null);
        this.cCY.execute(new Object[0]);
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
        if (this.bRk != null && !this.bRk.isRecycled()) {
            this.bRk.recycle();
            this.bRk = null;
        }
        if (this.cCY != null) {
            this.cCY.cancel();
            this.cCY = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cDa);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cDd.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.LG);
        com.baidu.tbadk.core.util.ay.j(this.mNavigationBar, com.baidu.tieba.n.alpha80_black);
        getLayoutMode().j(this.cCW);
        getLayoutMode().j(this.mTitleText);
        this.cCX.setBackgroundResource(com.baidu.tieba.p.title_icon_bg_for_image);
        if (this.cCX.isEnabled()) {
            this.cBg.setTextColor(getResources().getColor(com.baidu.tieba.n.navi_done_text));
        } else {
            this.cBg.setTextColor(getResources().getColor(com.baidu.tieba.n.navi_done_text_d));
        }
    }

    private void initUI() {
        this.LG = findViewById(com.baidu.tieba.q.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.q.progress);
        this.mProgress.setVisibility(8);
        this.avb = (ImageView) findViewById(com.baidu.tieba.q.image);
        this.avb.setOnClickListener(new bv(this));
        if (this.mBitmap != null) {
            this.avb.setImageBitmap(this.mBitmap);
        }
        this.bRc = (HorizontalScrollView) findViewById(com.baidu.tieba.q.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.cCW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bw(this));
        this.cCX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.image_activity_save_button, (View.OnClickListener) null);
        this.cCX.setOnClickListener(new bx(this));
        this.cBg = (TextView) this.cCX.findViewById(com.baidu.tieba.q.save);
        if (TextUtils.isEmpty(this.cDb)) {
            if (this.bLE || this.requestCode != 12003) {
                this.cBg.setText(getPageContext().getString(com.baidu.tieba.t.done));
            } else {
                this.cBg.setText(getPageContext().getString(com.baidu.tieba.t.delete));
            }
        } else {
            this.cBg.setText(this.cDb);
        }
        this.bRq = (LinearLayout) findViewById(com.baidu.tieba.q.filters);
        this.bRm = com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.beautify));
        this.bRi = (LinearLayout) findViewById(com.baidu.tieba.q.beautify_rotate);
        this.bRh = (LinearLayout) findViewById(com.baidu.tieba.q.rotate);
        this.bRf = (RadioButton) findViewById(com.baidu.tieba.q.beautify_btn);
        this.bRg = (RadioButton) findViewById(com.baidu.tieba.q.rotate_btn);
        this.MG = (RadioGroup) findViewById(com.baidu.tieba.q.beautify_tabs);
        by byVar = new by(this);
        this.bRf.setOnCheckedChangeListener(byVar);
        this.bRg.setOnCheckedChangeListener(byVar);
        this.bRf.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.q.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.q.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.q.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.q.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bz bzVar = new bz(this);
        button.setOnClickListener(bzVar);
        button2.setOnClickListener(bzVar);
        button3.setOnClickListener(bzVar);
        button4.setOnClickListener(bzVar);
        this.bRi.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.bRo) {
            this.bRg.setPadding(0, this.bRg.getPaddingTop(), this.bRg.getPaddingRight(), this.bRg.getPaddingBottom());
            this.bRg.setChecked(true);
            this.bRc.setVisibility(8);
            this.bRf.setVisibility(8);
            this.MG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA(String str) {
        if (this.cCZ != null) {
            this.cCZ.cancel();
        }
        this.cCZ = new cc(this, null);
        this.cCZ.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ke(String str) {
        try {
            com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_PIC_DIR, str, this.bRk, 90);
            this.avb.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.bRk, i);
            if (d != null && com.baidu.tbadk.core.util.o.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.bRn));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.bRs != null && strArr != null) {
            this.bRq.removeAllViews();
            this.bRi.setVisibility(0);
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(getPageContext().getPageActivity(), com.baidu.tieba.r.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.q.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.hr().inflate(getPageContext().getPageActivity(), com.baidu.tieba.r.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.q.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.q.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.ee(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new ca(this, substring, i2));
                    this.bRu = imageView2;
                } else {
                    imageView2.setOnClickListener(new cb(this, substring, i2));
                }
                this.bRq.addView(inflate2);
                synchronized (this.cDc) {
                    this.bRt.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            iB(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.bRp != null && (imageView = this.bRt.get(this.bRp)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.bRm, this.bRm, this.bRm, this.bRm);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.bRt != null) {
                ImageView imageView2 = this.bRt.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.p.bg_choose_filter);
                    imageView2.setPadding(this.bRm, this.bRm, this.bRm, this.bRm);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.bRp = str;
            }
        }
    }

    private void regReceiver() {
        this.cDa = new cj(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cDa, intentFilter);
    }
}
