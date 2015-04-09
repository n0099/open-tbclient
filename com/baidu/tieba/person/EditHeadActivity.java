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
    private View bOV;
    private View bOW;
    private RadioButton bPc;
    private RadioButton bPd;
    private LinearLayout bPn;
    private HashMap<String, Bitmap> bPp;
    private HashMap<String, ImageView> bPq;
    private View bPr;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String bOS = "change";
    public static String FILE_NAME = "file_name";
    private static String[] bOT = null;
    private EditHeadsImageView bOU = null;
    private Bitmap mBitmap = null;
    private int bnF = 0;
    private Button bOX = null;
    private Button bOY = null;
    private HorizontalScrollView bOZ = null;
    private ProgressBar mProgress = null;
    private q bPa = null;
    private n bPb = null;
    private LinearLayout bPe = null;
    private LinearLayout bPf = null;
    private s bPg = null;
    private TextView mTitle = null;
    private Bitmap bPh = null;
    private r bPi = null;
    private int bPj = 0;
    private int bPk = 0;
    private boolean bPl = true;
    private String bPm = null;
    private boolean bPo = false;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.gz().ag("motu_sdk") == 1 || PluginPackageManager.ls().br(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.bPl = false;
        } else {
            this.bPl = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.edit_head_activity);
        Intent intent = getIntent();
        this.bnF = intent.getIntExtra("edit_type", 0);
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
        bOT = getResources().getStringArray(com.baidu.tieba.q.fiter_name);
        if (this.bPl) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ba.j(this.mNavigationBar, com.baidu.tieba.s.alpha80_black);
        getLayoutMode().h(this.bOV);
        getLayoutMode().h(this.mTitle);
        getLayoutMode().h(this.bOW);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.bPa != null) {
            this.bPa.cancel();
        }
        this.bOU.setImageDrawable(null);
        acZ();
    }

    private void acZ() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.bPa != null) {
            this.bPa.cancel();
        }
        this.bPa = new q(this, null);
        this.bPa.execute(new Object[0]);
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
        this.bOU.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.bPg != null) {
            this.bPg.cancel();
        }
        if (this.bPh != null && !this.bPh.isRecycled()) {
            this.bPh.recycle();
            this.bPh = null;
        }
        if (this.bPa != null) {
            this.bPa.cancel();
            this.bPa = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.bPi);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ada() {
        if (this.bPg != null) {
            this.bPg.cancel();
        }
        this.bPg = new s(this, null);
        this.bPg.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mProgress.setVisibility(8);
        this.bOU = (EditHeadsImageView) findViewById(com.baidu.tieba.v.image);
        if (this.mBitmap != null) {
            this.bOU.setImageBitmap(this.mBitmap);
        }
        this.bOZ = (HorizontalScrollView) findViewById(com.baidu.tieba.v.filters_layout);
        this.bOV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.bOY = (Button) findViewById(com.baidu.tieba.v.show_button);
        this.bOY.setOnClickListener(new f(this));
        this.bOX = (Button) findViewById(com.baidu.tieba.v.hide_button);
        this.bOX.setVisibility(0);
        this.bOX.setOnClickListener(new g(this));
        this.bOW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.image_activity_save_button, (View.OnClickListener) null);
        this.bOW.setOnClickListener(new h(this));
        this.bOW.setEnabled(false);
        ((TextView) this.bOW.findViewById(com.baidu.tieba.v.save)).setText(com.baidu.tieba.y.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.beautify));
        this.bPn = (LinearLayout) findViewById(com.baidu.tieba.v.filters);
        this.bPj = com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bPf = (LinearLayout) findViewById(com.baidu.tieba.v.beautify_rotate);
        this.bPe = (LinearLayout) findViewById(com.baidu.tieba.v.rotate);
        this.bPc = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.bPd = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        j jVar = new j(this);
        this.bPc.setOnCheckedChangeListener(jVar);
        this.bPd.setOnCheckedChangeListener(jVar);
        this.bPc.setChecked(true);
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
    public void hW(String str) {
        if (this.bPb != null) {
            this.bPb.cancel();
        }
        this.bPb = new n(this, null);
        this.bPb.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.o.a(null, str, bitmap, 80);
            if (this.bPo) {
                new com.baidu.tbadk.core.util.ay("motu_pic", String.valueOf(this.bPk)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String[] strArr) {
        if (this.bPp != null && strArr != null) {
            this.bPn.removeAllViews();
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
                    imageView2.setOnClickListener(new l(this, substring, i2));
                    this.bPr = imageView2;
                } else {
                    imageView2.setOnClickListener(new m(this, substring, i2));
                }
                this.bPn.addView(inflate2);
                if (this.bPq != null) {
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
            if (this.bPq == null) {
                this.bPq = new HashMap<>();
            }
            if (this.bPm != null && (imageView = this.bPq.get(this.bPm)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.bPj, this.bPj, this.bPj, this.bPj);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.bPq.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.u.round_corner);
                imageView2.setPadding(this.bPj, this.bPj, this.bPj, this.bPj);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.bPm = str;
        }
    }

    private void regReceiver() {
        this.bPi = new r(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.bPi, intentFilter);
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
