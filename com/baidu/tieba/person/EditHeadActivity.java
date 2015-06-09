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
    private View bQZ;
    private View bRa;
    private RadioButton bRg;
    private RadioButton bRh;
    private LinearLayout bRr;
    private HashMap<String, Bitmap> bRt;
    private HashMap<String, ImageView> bRu;
    private View bRv;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String bQV = "change";
    public static String FILE_NAME = "file_name";
    private static String[] bQX = null;
    private float bQW = 1.0f;
    private EditHeadsImageView bQY = null;
    private Bitmap mBitmap = null;
    private int bql = 0;
    private Button bRb = null;
    private Button bRc = null;
    private HorizontalScrollView bRd = null;
    private ProgressBar mProgress = null;
    private q bRe = null;
    private n bRf = null;
    private LinearLayout bRi = null;
    private LinearLayout bRj = null;
    private s bRk = null;
    private TextView mTitle = null;
    private Bitmap bRl = null;
    private r bRm = null;
    private int bRn = 0;
    private int bRo = 0;
    private boolean bRp = true;
    private String bRq = null;
    private boolean bRs = false;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.gD().ai("motu_sdk") == 1 || PluginPackageManager.lM().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.bRp = false;
        } else {
            this.bRp = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.r.edit_head_activity);
        Intent intent = getIntent();
        this.bql = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.bQW = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.bc.tB().tH());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.bc.tB().tH(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        bQX = getResources().getStringArray(com.baidu.tieba.l.fiter_name);
        if (this.bRp) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ay.j(this.mNavigationBar, com.baidu.tieba.n.alpha80_black);
        getLayoutMode().j(this.bQZ);
        getLayoutMode().j(this.mTitle);
        getLayoutMode().j(this.bRa);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.bRe != null) {
            this.bRe.cancel();
        }
        this.bQY.setImageDrawable(null);
        aea();
    }

    private void aea() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.bRe != null) {
            this.bRe.cancel();
        }
        this.bRe = new q(this, null);
        this.bRe.execute(new Object[0]);
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
        this.bQY.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.bRk != null) {
            this.bRk.cancel();
        }
        if (this.bRl != null && !this.bRl.isRecycled()) {
            this.bRl.recycle();
            this.bRl = null;
        }
        if (this.bRe != null) {
            this.bRe.cancel();
            this.bRe = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.bRm);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeb() {
        if (this.bRk != null) {
            this.bRk.cancel();
        }
        this.bRk = new s(this, null);
        this.bRk.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.q.progress);
        this.mProgress.setVisibility(8);
        this.bQY = (EditHeadsImageView) findViewById(com.baidu.tieba.q.image);
        this.bQY.setCutImageHeightScale(this.bQW);
        if (this.mBitmap != null) {
            this.bQY.setImageBitmap(this.mBitmap);
        }
        this.bRd = (HorizontalScrollView) findViewById(com.baidu.tieba.q.filters_layout);
        this.bQZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.bRc = (Button) findViewById(com.baidu.tieba.q.show_button);
        this.bRc.setOnClickListener(new f(this));
        this.bRb = (Button) findViewById(com.baidu.tieba.q.hide_button);
        this.bRb.setVisibility(0);
        this.bRb.setOnClickListener(new g(this));
        this.bRa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.image_activity_save_button, (View.OnClickListener) null);
        this.bRa.setOnClickListener(new h(this));
        this.bRa.setEnabled(false);
        ((TextView) this.bRa.findViewById(com.baidu.tieba.q.save)).setText(com.baidu.tieba.t.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.beautify));
        this.bRr = (LinearLayout) findViewById(com.baidu.tieba.q.filters);
        this.bRn = com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bRj = (LinearLayout) findViewById(com.baidu.tieba.q.beautify_rotate);
        this.bRi = (LinearLayout) findViewById(com.baidu.tieba.q.rotate);
        this.bRg = (RadioButton) findViewById(com.baidu.tieba.q.beautify_btn);
        this.bRh = (RadioButton) findViewById(com.baidu.tieba.q.rotate_btn);
        j jVar = new j(this);
        this.bRg.setOnCheckedChangeListener(jVar);
        this.bRh.setOnCheckedChangeListener(jVar);
        this.bRg.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.q.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.q.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.q.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.q.rotate_up_down);
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
    public void iA(String str) {
        if (this.bRf != null) {
            this.bRf.cancel();
        }
        this.bRf = new n(this, null);
        this.bRf.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.o.a(null, str, bitmap, 80);
            if (this.bRs) {
                new com.baidu.tbadk.core.util.aw("motu_pic", String.valueOf(this.bRo)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.bRt != null && strArr != null) {
            this.bRr.removeAllViews();
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
                    imageView2.setOnClickListener(new l(this, substring, i2));
                    this.bRv = imageView2;
                } else {
                    imageView2.setOnClickListener(new m(this, substring, i2));
                }
                this.bRr.addView(inflate2);
                if (this.bRu != null) {
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
            if (this.bRu == null) {
                this.bRu = new HashMap<>();
            }
            if (this.bRq != null && (imageView = this.bRu.get(this.bRq)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.bRn, this.bRn, this.bRn, this.bRn);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.bRu.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.p.round_corner);
                imageView2.setPadding(this.bRn, this.bRn, this.bRn, this.bRn);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.bRq = str;
        }
    }

    private void regReceiver() {
        this.bRm = new r(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.bRm, intentFilter);
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
