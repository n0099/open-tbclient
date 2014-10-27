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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity {
    private static String[] Jy = null;
    private RadioButton JH;
    private RadioButton JI;
    private LinearLayout JT;
    private int JV;
    private HashMap<String, Bitmap> JW;
    private HashMap<String, ImageView> JX;
    private View JY;
    private String bUg;
    private ImageView acF = null;
    private Bitmap mBitmap = null;
    private TextView bSs = null;
    private View agA = null;
    private HorizontalScrollView JE = null;
    private ProgressBar mProgress = null;
    private cc bUd = null;
    private bw bUe = null;
    private LinearLayout JJ = null;
    private LinearLayout JK = null;
    private TextView atA = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap JN = null;
    private cd bUf = null;
    private int JP = 0;
    private int JQ = 0;
    private int mDisplaySize = 0;
    private boolean JR = true;
    private String JS = null;
    private boolean JU = false;
    private boolean bwI = false;
    private final Handler mHandler = new Handler();
    private final Object bUh = new Object();
    private final View.OnClickListener bUi = new bo(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.db().U("motu_sdk") == 1 || PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_MOTUSDK) == null) {
            this.JR = false;
        } else {
            this.JR = true;
        }
        TbadkApplication.m251getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.write_image_activity);
        Intent intent = getIntent();
        this.JV = intent.getIntExtra(WriteImageActivityConfig.FROMCODE, 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.bUg = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.JR) {
            TbadkApplication.m251getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.bwI = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.JV == 12002 || this.JV == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.JV, intent.getData(), com.baidu.tbadk.core.util.az.mD().mJ(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.JV, null, com.baidu.tbadk.core.util.az.mD().mJ(), this.mDisplaySize, stringExtra);
            }
            nY();
        } else {
            initUI();
            initData();
        }
        Jy = getResources().getStringArray(com.baidu.tieba.q.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.bUd != null) {
            this.bUd.cancel();
        }
        this.acF.setImageDrawable(null);
        nW();
    }

    private void nW() {
        synchronized (this.bUh) {
            if (this.JX != null) {
                for (Map.Entry<String, ImageView> entry : this.JX.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.JX.clear();
                this.JX = null;
            }
            if (this.JW != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.JW.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.JW.clear();
                this.JW = null;
            }
        }
    }

    public void initData() {
        if (this.bUd != null) {
            this.bUd.cancel();
        }
        this.bUd = new cc(this, null);
        this.bUd.execute(new Object[0]);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.JN != null && !this.JN.isRecycled()) {
            this.JN.recycle();
            this.JN = null;
        }
        if (this.bUd != null) {
            this.bUd.cancel();
            this.bUd = null;
        }
        this.mProgress.setVisibility(8);
        if (this.JV == 12002 || this.JV == 12001) {
            unregisterReceiver(this.bUf);
        }
        TbadkApplication.m251getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.bUi.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.agA);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.bSs.isEnabled()) {
            com.baidu.tbadk.core.util.aw.h((View) this.bSs, com.baidu.tieba.u.navi_done_text_bg);
            com.baidu.tbadk.core.util.aw.b(this.bSs, com.baidu.tieba.s.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.aw.h((View) this.bSs, com.baidu.tieba.u.btn_titlebar_finish_d);
        this.bSs.setTextColor(getResources().getColor(com.baidu.tieba.s.navi_done_text_d));
        com.baidu.tbadk.core.util.aw.b(this.bSs, com.baidu.tieba.s.navi_done_text_d, 1);
    }

    private void initUI() {
        this.agA = findViewById(com.baidu.tieba.v.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mProgress.setVisibility(8);
        this.acF = (ImageView) findViewById(com.baidu.tieba.v.image);
        this.acF.setOnClickListener(new bp(this));
        if (this.mBitmap != null) {
            this.acF.setImageBitmap(this.mBitmap);
        }
        this.JE = (HorizontalScrollView) findViewById(com.baidu.tieba.v.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bq(this));
        this.bSs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bUg, new br(this));
        if (TextUtils.isEmpty(this.bUg)) {
            if (this.bwI || this.JV != 12003) {
                this.bSs.setText(getString(com.baidu.tieba.y.done));
                com.baidu.tbadk.core.util.aw.f(this.bSs, TbadkApplication.m251getInst().getSkinType());
            } else {
                this.bSs.setText(getString(com.baidu.tieba.y.delete));
                com.baidu.tbadk.core.util.aw.j(this.bSs, TbadkApplication.m251getInst().getSkinType());
            }
        } else {
            this.bSs.setText(this.bUg);
        }
        this.JT = (LinearLayout) findViewById(com.baidu.tieba.v.filters);
        this.JP = com.baidu.adp.lib.util.m.dip2px(this, 2.0f);
        this.atA = this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.beautify));
        this.JK = (LinearLayout) findViewById(com.baidu.tieba.v.beautify_rotate);
        this.JJ = (LinearLayout) findViewById(com.baidu.tieba.v.rotate);
        this.JH = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.JI = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        bs bsVar = new bs(this);
        this.JH.setOnCheckedChangeListener(bsVar);
        this.JI.setOnCheckedChangeListener(bsVar);
        this.JH.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.v.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.v.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.v.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.v.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bt btVar = new bt(this);
        button.setOnClickListener(btVar);
        button2.setOnClickListener(btVar);
        button3.setOnClickListener(btVar);
        button4.setOnClickListener(btVar);
        this.JK.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.JR) {
            this.JI.setPadding(0, this.JI.getPaddingTop(), this.JI.getPaddingRight(), this.JI.getPaddingBottom());
            this.JI.setChecked(true);
            this.JE.setVisibility(8);
            this.JH.setVisibility(8);
        }
    }

    public void ck(String str) {
        if (this.bUe != null) {
            this.bUe.cancel();
        }
        this.bUe = new bw(this, null);
        this.bUe.execute(str);
    }

    public boolean hK(String str) {
        try {
            com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_PIC_DIR, str, this.JN, 90);
            this.acF.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap a = com.baidu.tbadk.core.util.d.a(this.JN, i);
            if (a != null && com.baidu.tbadk.core.util.s.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, a, 80) != null) {
                TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.JQ));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    public void i(String[] strArr) {
        if (this.JW != null && strArr != null) {
            this.JT.removeAllViews();
            this.JK.setVisibility(0);
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.v.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.v.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.v.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.cK(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                    this.JY = imageView2;
                } else {
                    imageView2.setOnClickListener(new bv(this, substring, i2));
                }
                this.JT.addView(inflate2);
                synchronized (this.bUh) {
                    this.JX.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            cl(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    public void cl(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.JS != null && (imageView = this.JX.get(this.JS)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.JP, this.JP, this.JP, this.JP);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.JX != null) {
                ImageView imageView2 = this.JX.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                    imageView2.setPadding(this.JP, this.JP, this.JP, this.JP);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.JS = str;
            }
        }
    }

    private void nY() {
        this.bUf = new cd(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.bUf, intentFilter);
    }
}
