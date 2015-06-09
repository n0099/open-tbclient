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
    private static String[] bQX = null;
    private RadioButton bRg;
    private RadioButton bRh;
    private LinearLayout bRr;
    private HashMap<String, Bitmap> bRt;
    private HashMap<String, ImageView> bRu;
    private View bRv;
    private View cCX;
    private View cCY;
    private String cDc;
    private int requestCode;
    private ImageView avb = null;
    private Bitmap mBitmap = null;
    private TextView cBh = null;
    private View LG = null;
    private HorizontalScrollView bRd = null;
    private ProgressBar mProgress = null;
    private ci cCZ = null;
    private cc cDa = null;
    private RadioGroup MG = null;
    private LinearLayout bRi = null;
    private LinearLayout bRj = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap bRl = null;
    private cj cDb = null;
    private int bRn = 0;
    private int bRo = 0;
    private int mDisplaySize = 0;
    private boolean bRp = true;
    private String bRq = null;
    private boolean bRs = false;
    private boolean bLF = false;
    private final Handler mHandler = new Handler();
    private final Object cDd = new Object();
    private final View.OnClickListener cDe = new bu(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.f.gD().ai("motu_sdk") == 1 || PluginPackageManager.lM().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.bRp = false;
        } else {
            this.bRp = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(com.baidu.tieba.r.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.cDc = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.bRp) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.bLF = true;
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
        bQX = getResources().getStringArray(com.baidu.tieba.l.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cCZ != null) {
            this.cCZ.cancel();
        }
        this.avb.setImageDrawable(null);
        aea();
    }

    private void aea() {
        synchronized (this.cDd) {
            if (this.bRu != null) {
                for (Map.Entry<String, ImageView> entry : this.bRu.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.bRu.clear();
                this.bRu = null;
            }
            if (this.bRt != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.bRt.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.bRt.clear();
                this.bRt = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cCZ != null) {
            this.cCZ.cancel();
        }
        this.cCZ = new ci(this, null);
        this.cCZ.execute(new Object[0]);
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
        if (this.bRl != null && !this.bRl.isRecycled()) {
            this.bRl.recycle();
            this.bRl = null;
        }
        if (this.cCZ != null) {
            this.cCZ.cancel();
            this.cCZ = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cDb);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cDe.onClick(null);
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
        getLayoutMode().j(this.cCX);
        getLayoutMode().j(this.mTitleText);
        this.cCY.setBackgroundResource(com.baidu.tieba.p.title_icon_bg_for_image);
        if (this.cCY.isEnabled()) {
            this.cBh.setTextColor(getResources().getColor(com.baidu.tieba.n.navi_done_text));
        } else {
            this.cBh.setTextColor(getResources().getColor(com.baidu.tieba.n.navi_done_text_d));
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
        this.bRd = (HorizontalScrollView) findViewById(com.baidu.tieba.q.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.cCX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bw(this));
        this.cCY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.image_activity_save_button, (View.OnClickListener) null);
        this.cCY.setOnClickListener(new bx(this));
        this.cBh = (TextView) this.cCY.findViewById(com.baidu.tieba.q.save);
        if (TextUtils.isEmpty(this.cDc)) {
            if (this.bLF || this.requestCode != 12003) {
                this.cBh.setText(getPageContext().getString(com.baidu.tieba.t.done));
            } else {
                this.cBh.setText(getPageContext().getString(com.baidu.tieba.t.delete));
            }
        } else {
            this.cBh.setText(this.cDc);
        }
        this.bRr = (LinearLayout) findViewById(com.baidu.tieba.q.filters);
        this.bRn = com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.beautify));
        this.bRj = (LinearLayout) findViewById(com.baidu.tieba.q.beautify_rotate);
        this.bRi = (LinearLayout) findViewById(com.baidu.tieba.q.rotate);
        this.bRg = (RadioButton) findViewById(com.baidu.tieba.q.beautify_btn);
        this.bRh = (RadioButton) findViewById(com.baidu.tieba.q.rotate_btn);
        this.MG = (RadioGroup) findViewById(com.baidu.tieba.q.beautify_tabs);
        by byVar = new by(this);
        this.bRg.setOnCheckedChangeListener(byVar);
        this.bRh.setOnCheckedChangeListener(byVar);
        this.bRg.setChecked(true);
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
        this.bRj.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.bRp) {
            this.bRh.setPadding(0, this.bRh.getPaddingTop(), this.bRh.getPaddingRight(), this.bRh.getPaddingBottom());
            this.bRh.setChecked(true);
            this.bRd.setVisibility(8);
            this.bRg.setVisibility(8);
            this.MG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA(String str) {
        if (this.cDa != null) {
            this.cDa.cancel();
        }
        this.cDa = new cc(this, null);
        this.cDa.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ke(String str) {
        try {
            com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_PIC_DIR, str, this.bRl, 90);
            this.avb.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.bRl, i);
            if (d != null && com.baidu.tbadk.core.util.o.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.bRo));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.bRt != null && strArr != null) {
            this.bRr.removeAllViews();
            this.bRj.setVisibility(0);
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
                    this.bRv = imageView2;
                } else {
                    imageView2.setOnClickListener(new cb(this, substring, i2));
                }
                this.bRr.addView(inflate2);
                synchronized (this.cDd) {
                    this.bRu.put(substring, imageView2);
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
            if (this.bRq != null && (imageView = this.bRu.get(this.bRq)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.bRn, this.bRn, this.bRn, this.bRn);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.bRu != null) {
                ImageView imageView2 = this.bRu.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.p.bg_choose_filter);
                    imageView2.setPadding(this.bRn, this.bRn, this.bRn, this.bRn);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.bRq = str;
            }
        }
    }

    private void regReceiver() {
        this.cDb = new cj(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cDb, intentFilter);
    }
}
