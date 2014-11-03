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
    private static String[] Jz = null;
    private RadioButton JI;
    private RadioButton JJ;
    private LinearLayout JU;
    private int JW;
    private HashMap<String, Bitmap> JX;
    private HashMap<String, ImageView> JY;
    private View JZ;
    private String bUv;
    private ImageView acK = null;
    private Bitmap mBitmap = null;
    private TextView bSH = null;
    private View agI = null;
    private HorizontalScrollView JF = null;
    private ProgressBar mProgress = null;
    private cc bUs = null;
    private bw bUt = null;
    private LinearLayout JK = null;
    private LinearLayout JL = null;
    private TextView atJ = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap JO = null;
    private cd bUu = null;
    private int JQ = 0;
    private int JR = 0;
    private int mDisplaySize = 0;
    private boolean JS = true;
    private String JT = null;
    private boolean JV = false;
    private boolean bwW = false;
    private final Handler mHandler = new Handler();
    private final Object bUw = new Object();
    private final View.OnClickListener bUx = new bo(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.db().U("motu_sdk") == 1 || PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_MOTUSDK) == null) {
            this.JS = false;
        } else {
            this.JS = true;
        }
        TbadkApplication.m251getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.write_image_activity);
        Intent intent = getIntent();
        this.JW = intent.getIntExtra(WriteImageActivityConfig.FROMCODE, 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.bUv = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.JS) {
            TbadkApplication.m251getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.bwW = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.JW == 12002 || this.JW == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.JW, intent.getData(), com.baidu.tbadk.core.util.ba.mD().mJ(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.JW, null, com.baidu.tbadk.core.util.ba.mD().mJ(), this.mDisplaySize, stringExtra);
            }
            nY();
        } else {
            initUI();
            initData();
        }
        Jz = getResources().getStringArray(com.baidu.tieba.q.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.bUs != null) {
            this.bUs.cancel();
        }
        this.acK.setImageDrawable(null);
        nW();
    }

    private void nW() {
        synchronized (this.bUw) {
            if (this.JY != null) {
                for (Map.Entry<String, ImageView> entry : this.JY.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.JY.clear();
                this.JY = null;
            }
            if (this.JX != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.JX.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.JX.clear();
                this.JX = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.bUs != null) {
            this.bUs.cancel();
        }
        this.bUs = new cc(this, null);
        this.bUs.execute(new Object[0]);
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
        if (this.JO != null && !this.JO.isRecycled()) {
            this.JO.recycle();
            this.JO = null;
        }
        if (this.bUs != null) {
            this.bUs.cancel();
            this.bUs = null;
        }
        this.mProgress.setVisibility(8);
        if (this.JW == 12002 || this.JW == 12001) {
            unregisterReceiver(this.bUu);
        }
        TbadkApplication.m251getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.bUx.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.agI);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.bSH.isEnabled()) {
            com.baidu.tbadk.core.util.aw.h((View) this.bSH, com.baidu.tieba.u.navi_done_text_bg);
            com.baidu.tbadk.core.util.aw.b(this.bSH, com.baidu.tieba.s.navi_done_text, 1);
            return;
        }
        com.baidu.tbadk.core.util.aw.h((View) this.bSH, com.baidu.tieba.u.btn_titlebar_finish_d);
        this.bSH.setTextColor(getResources().getColor(com.baidu.tieba.s.navi_done_text_d));
        com.baidu.tbadk.core.util.aw.b(this.bSH, com.baidu.tieba.s.navi_done_text_d, 1);
    }

    private void initUI() {
        this.agI = findViewById(com.baidu.tieba.v.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mProgress.setVisibility(8);
        this.acK = (ImageView) findViewById(com.baidu.tieba.v.image);
        this.acK.setOnClickListener(new bp(this));
        if (this.mBitmap != null) {
            this.acK.setImageBitmap(this.mBitmap);
        }
        this.JF = (HorizontalScrollView) findViewById(com.baidu.tieba.v.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bq(this));
        this.bSH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bUv, new br(this));
        if (TextUtils.isEmpty(this.bUv)) {
            if (this.bwW || this.JW != 12003) {
                this.bSH.setText(getString(com.baidu.tieba.y.done));
                com.baidu.tbadk.core.util.aw.f(this.bSH, TbadkApplication.m251getInst().getSkinType());
            } else {
                this.bSH.setText(getString(com.baidu.tieba.y.delete));
                com.baidu.tbadk.core.util.aw.j(this.bSH, TbadkApplication.m251getInst().getSkinType());
            }
        } else {
            this.bSH.setText(this.bUv);
        }
        this.JU = (LinearLayout) findViewById(com.baidu.tieba.v.filters);
        this.JQ = com.baidu.adp.lib.util.m.dip2px(this, 2.0f);
        this.atJ = this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.beautify));
        this.JL = (LinearLayout) findViewById(com.baidu.tieba.v.beautify_rotate);
        this.JK = (LinearLayout) findViewById(com.baidu.tieba.v.rotate);
        this.JI = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.JJ = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        bs bsVar = new bs(this);
        this.JI.setOnCheckedChangeListener(bsVar);
        this.JJ.setOnCheckedChangeListener(bsVar);
        this.JI.setChecked(true);
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
        this.JL.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.JS) {
            this.JJ.setPadding(0, this.JJ.getPaddingTop(), this.JJ.getPaddingRight(), this.JJ.getPaddingBottom());
            this.JJ.setChecked(true);
            this.JF.setVisibility(8);
            this.JI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(String str) {
        if (this.bUt != null) {
            this.bUt.cancel();
        }
        this.bUt = new bw(this, null);
        this.bUt.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hK(String str) {
        try {
            com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_PIC_DIR, str, this.JO, 90);
            this.acK.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap a = com.baidu.tbadk.core.util.d.a(this.JO, i);
            if (a != null && com.baidu.tbadk.core.util.s.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, a, 80) != null) {
                TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.JR));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String[] strArr) {
        if (this.JX != null && strArr != null) {
            this.JU.removeAllViews();
            this.JL.setVisibility(0);
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
                    this.JZ = imageView2;
                } else {
                    imageView2.setOnClickListener(new bv(this, substring, i2));
                }
                this.JU.addView(inflate2);
                synchronized (this.bUw) {
                    this.JY.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            cl(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.JT != null && (imageView = this.JY.get(this.JT)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.JQ, this.JQ, this.JQ, this.JQ);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.JY != null) {
                ImageView imageView2 = this.JY.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                    imageView2.setPadding(this.JQ, this.JQ, this.JQ, this.JQ);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.JT = str;
            }
        }
    }

    private void nY() {
        this.bUu = new cd(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.bUu, intentFilter);
    }
}
