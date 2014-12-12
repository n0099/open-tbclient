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
    private static String[] OG = null;
    private RadioButton OT;
    private RadioButton OV;
    private LinearLayout Pf;
    private HashMap<String, Bitmap> Ph;
    private HashMap<String, ImageView> Pi;
    private View Pj;
    private View cfA;
    private String cfE;
    private View cfz;
    private int requestCode;
    private ImageView akv = null;
    private Bitmap mBitmap = null;
    private TextView cdN = null;
    private View mParent = null;
    private HorizontalScrollView OP = null;
    private ProgressBar mProgress = null;
    private cc cfB = null;
    private bw cfC = null;
    private LinearLayout OW = null;
    private LinearLayout OX = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap OZ = null;
    private cd cfD = null;
    private int Pb = 0;
    private int Pc = 0;
    private int mDisplaySize = 0;
    private boolean Pd = true;
    private String Pe = null;
    private boolean Pg = false;
    private boolean bAO = false;
    private final Handler mHandler = new Handler();
    private final Object cfF = new Object();
    private final View.OnClickListener cfG = new bo(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.dc().Z("motu_sdk") == 1 || PluginPackageManager.ic().bm("com.baidu.tieba.pluginMotu") == PluginPackageManager.PluginStatus.DISABLE) {
            this.Pd = false;
        } else {
            this.Pd = true;
        }
        TbadkCoreApplication.m255getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(com.baidu.tieba.x.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.cfE = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.Pd) {
            TbadkCoreApplication.m255getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.bAO = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.bb.px().pD(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.bb.px().pD(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        OG = getResources().getStringArray(com.baidu.tieba.r.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cfB != null) {
            this.cfB.cancel();
        }
        this.akv.setImageDrawable(null);
        qY();
    }

    private void qY() {
        synchronized (this.cfF) {
            if (this.Pi != null) {
                for (Map.Entry<String, ImageView> entry : this.Pi.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.Pi.clear();
                this.Pi = null;
            }
            if (this.Ph != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.Ph.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.Ph.clear();
                this.Ph = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cfB != null) {
            this.cfB.cancel();
        }
        this.cfB = new cc(this, null);
        this.cfB.execute(new Object[0]);
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
        if (this.OZ != null && !this.OZ.isRecycled()) {
            this.OZ.recycle();
            this.OZ = null;
        }
        if (this.cfB != null) {
            this.cfB.cancel();
            this.cfB = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cfD);
        }
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cfG.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        com.baidu.tbadk.core.util.ax.j(this.mNavigationBar, com.baidu.tieba.t.alpha80_black);
        getLayoutMode().h(this.cfz);
        getLayoutMode().h(this.mTitleText);
        this.cfA.setBackgroundResource(com.baidu.tieba.v.title_icon_bg_for_image);
        if (this.cfA.isEnabled()) {
            this.cdN.setTextColor(getResources().getColor(com.baidu.tieba.t.navi_done_text));
        } else {
            this.cdN.setTextColor(getResources().getColor(com.baidu.tieba.t.navi_done_text_d));
        }
    }

    private void initUI() {
        this.mParent = findViewById(com.baidu.tieba.w.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.mProgress.setVisibility(8);
        this.akv = (ImageView) findViewById(com.baidu.tieba.w.image);
        this.akv.setOnClickListener(new bp(this));
        if (this.mBitmap != null) {
            this.akv.setImageBitmap(this.mBitmap);
        }
        this.OP = (HorizontalScrollView) findViewById(com.baidu.tieba.w.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.cfz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bq(this));
        this.cfA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.image_activity_save_button, (View.OnClickListener) null);
        this.cfA.setOnClickListener(new br(this));
        this.cdN = (TextView) this.cfA.findViewById(com.baidu.tieba.w.save);
        if (TextUtils.isEmpty(this.cfE)) {
            if (this.bAO || this.requestCode != 12003) {
                this.cdN.setText(getPageContext().getString(com.baidu.tieba.z.done));
            } else {
                this.cdN.setText(getPageContext().getString(com.baidu.tieba.z.delete));
            }
        } else {
            this.cdN.setText(this.cfE);
        }
        this.Pf = (LinearLayout) findViewById(com.baidu.tieba.w.filters);
        this.Pb = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.beautify));
        this.OX = (LinearLayout) findViewById(com.baidu.tieba.w.beautify_rotate);
        this.OW = (LinearLayout) findViewById(com.baidu.tieba.w.rotate);
        this.OT = (RadioButton) findViewById(com.baidu.tieba.w.beautify_btn);
        this.OV = (RadioButton) findViewById(com.baidu.tieba.w.rotate_btn);
        bs bsVar = new bs(this);
        this.OT.setOnCheckedChangeListener(bsVar);
        this.OV.setOnCheckedChangeListener(bsVar);
        this.OT.setChecked(true);
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
        this.OX.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.Pd) {
            this.OV.setPadding(0, this.OV.getPaddingTop(), this.OV.getPaddingRight(), this.OV.getPaddingBottom());
            this.OV.setChecked(true);
            this.OP.setVisibility(8);
            this.OT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        if (this.cfC != null) {
            this.cfC.cancel();
        }
        this.cfC = new bw(this, null);
        this.cfC.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iw(String str) {
        try {
            com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_PIC_DIR, str, this.OZ, 90);
            this.akv.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.d.d(this.OZ, i);
            if (d != null && com.baidu.tbadk.core.util.s.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.Pc));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String[] strArr) {
        if (this.Ph != null && strArr != null) {
            this.Pf.removeAllViews();
            this.OX.setVisibility(0);
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.w.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.w.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.w.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.dG(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                    this.Pj = imageView2;
                } else {
                    imageView2.setOnClickListener(new bv(this, substring, i2));
                }
                this.Pf.addView(inflate2);
                synchronized (this.cfF) {
                    this.Pi.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            de(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.Pe != null && (imageView = this.Pi.get(this.Pe)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.Pb, this.Pb, this.Pb, this.Pb);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.Pi != null) {
                ImageView imageView2 = this.Pi.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.v.bg_choose_filter);
                    imageView2.setPadding(this.Pb, this.Pb, this.Pb, this.Pb);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.Pe = str;
            }
        }
    }

    private void regReceiver() {
        this.cfD = new cd(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cfD, intentFilter);
    }
}
