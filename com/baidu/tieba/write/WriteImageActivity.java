package com.baidu.tieba.write;

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
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
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
    private static String[] Pk = null;
    private LinearLayout PG;
    private HashMap<String, Bitmap> PJ;
    private HashMap<String, ImageView> PK;
    private View PL;
    private RadioButton Pu;
    private RadioButton Pv;
    private View cgZ;
    private View cha;
    private String che;
    private int requestCode;
    private ImageView anr = null;
    private Bitmap mBitmap = null;
    private TextView cfm = null;
    private View mParent = null;
    private HorizontalScrollView Pr = null;
    private ProgressBar mProgress = null;
    private cc chb = null;
    private bw chc = null;
    private LinearLayout Pw = null;
    private LinearLayout Px = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap Pz = null;
    private cd chd = null;
    private int PC = 0;
    private int PD = 0;
    private int mDisplaySize = 0;
    private boolean PE = true;
    private String PF = null;
    private boolean PH = false;
    private boolean bCy = false;
    private final Handler mHandler = new Handler();
    private final Object chf = new Object();
    private final View.OnClickListener chg = new bo(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.da().Z("motu_sdk") == 1 || PluginPackageManager.ic().bm("com.baidu.tieba.pluginMotu") == PluginPackageManager.PluginStatus.DISABLE) {
            this.PE = false;
        } else {
            this.PE = true;
        }
        TbadkCoreApplication.m255getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(com.baidu.tieba.x.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.che = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.PE) {
            TbadkCoreApplication.m255getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.bCy = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.bg.pI().pO(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.bg.pI().pO(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        Pk = getResources().getStringArray(com.baidu.tieba.r.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.chb != null) {
            this.chb.cancel();
        }
        this.anr.setImageDrawable(null);
        rj();
    }

    private void rj() {
        synchronized (this.chf) {
            if (this.PK != null) {
                for (Map.Entry<String, ImageView> entry : this.PK.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.PK.clear();
                this.PK = null;
            }
            if (this.PJ != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.PJ.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.PJ.clear();
                this.PJ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.chb != null) {
            this.chb.cancel();
        }
        this.chb = new cc(this, null);
        this.chb.execute(new Object[0]);
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
        if (this.Pz != null && !this.Pz.isRecycled()) {
            this.Pz.recycle();
            this.Pz = null;
        }
        if (this.chb != null) {
            this.chb.cancel();
            this.chb = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.chd);
        }
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.chg.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        com.baidu.tbadk.core.util.bc.j(this.mNavigationBar, com.baidu.tieba.t.alpha80_black);
        getLayoutMode().h(this.cgZ);
        getLayoutMode().h(this.mTitleText);
        this.cha.setBackgroundResource(com.baidu.tieba.v.title_icon_bg_for_image);
        if (this.cha.isEnabled()) {
            this.cfm.setTextColor(getResources().getColor(com.baidu.tieba.t.navi_done_text));
        } else {
            this.cfm.setTextColor(getResources().getColor(com.baidu.tieba.t.navi_done_text_d));
        }
    }

    private void initUI() {
        this.mParent = findViewById(com.baidu.tieba.w.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.mProgress.setVisibility(8);
        this.anr = (ImageView) findViewById(com.baidu.tieba.w.image);
        this.anr.setOnClickListener(new bp(this));
        if (this.mBitmap != null) {
            this.anr.setImageBitmap(this.mBitmap);
        }
        this.Pr = (HorizontalScrollView) findViewById(com.baidu.tieba.w.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.cgZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bq(this));
        this.cha = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.image_activity_save_button, (View.OnClickListener) null);
        this.cha.setOnClickListener(new br(this));
        this.cfm = (TextView) this.cha.findViewById(com.baidu.tieba.w.save);
        if (TextUtils.isEmpty(this.che)) {
            if (this.bCy || this.requestCode != 12003) {
                this.cfm.setText(getPageContext().getString(com.baidu.tieba.z.done));
            } else {
                this.cfm.setText(getPageContext().getString(com.baidu.tieba.z.delete));
            }
        } else {
            this.cfm.setText(this.che);
        }
        this.PG = (LinearLayout) findViewById(com.baidu.tieba.w.filters);
        this.PC = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.beautify));
        this.Px = (LinearLayout) findViewById(com.baidu.tieba.w.beautify_rotate);
        this.Pw = (LinearLayout) findViewById(com.baidu.tieba.w.rotate);
        this.Pu = (RadioButton) findViewById(com.baidu.tieba.w.beautify_btn);
        this.Pv = (RadioButton) findViewById(com.baidu.tieba.w.rotate_btn);
        bs bsVar = new bs(this);
        this.Pu.setOnCheckedChangeListener(bsVar);
        this.Pv.setOnCheckedChangeListener(bsVar);
        this.Pu.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.w.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.w.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.w.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.w.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bt btVar = new bt(this);
        button.setOnClickListener(btVar);
        button2.setOnClickListener(btVar);
        button3.setOnClickListener(btVar);
        button4.setOnClickListener(btVar);
        this.Px.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.PE) {
            this.Pv.setPadding(0, this.Pv.getPaddingTop(), this.Pv.getPaddingRight(), this.Pv.getPaddingBottom());
            this.Pv.setChecked(true);
            this.Pr.setVisibility(8);
            this.Pu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(String str) {
        if (this.chc != null) {
            this.chc.cancel();
        }
        this.chc = new bw(this, null);
        this.chc.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iE(String str) {
        try {
            com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_PIC_DIR, str, this.Pz, 90);
            this.anr.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.d.d(this.Pz, i);
            if (d != null && com.baidu.tbadk.core.util.s.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.PD));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String[] strArr) {
        if (this.PJ != null && strArr != null) {
            this.PG.removeAllViews();
            this.Px.setVisibility(0);
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.w.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.w.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.w.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.dF(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                    this.PL = imageView2;
                } else {
                    imageView2.setOnClickListener(new bv(this, substring, i2));
                }
                this.PG.addView(inflate2);
                synchronized (this.chf) {
                    this.PK.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            dd(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.PF != null && (imageView = this.PK.get(this.PF)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.PC, this.PC, this.PC, this.PC);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.PK != null) {
                ImageView imageView2 = this.PK.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.v.bg_choose_filter);
                    imageView2.setPadding(this.PC, this.PC, this.PC, this.PC);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.PF = str;
            }
        }
    }

    private void regReceiver() {
        this.chd = new cd(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.chd, intentFilter);
    }
}
