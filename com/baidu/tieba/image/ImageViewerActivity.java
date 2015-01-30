package com.baidu.tieba.image;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private boolean Uu;
    private String Uv;
    private boolean Ux;
    private NavigationBar aJn;
    private boolean aRc;
    private AlphaAnimation akZ;
    private ArrayList<String> brI;
    private String brJ;
    private q brL;
    private View brM;
    private View brN;
    private TextView brO;
    private MultiImageView brP;
    private p brQ;
    private a brR;
    private HashMap<String, Boolean> brT;
    private String brU;
    private String brV;
    private String brW;
    private boolean brX;
    private String bri;
    private int brH = 0;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean brK = true;
    private boolean aRb = true;
    private long brS = 0;
    private DialogInterface.OnClickListener brY = new g(this);
    private View.OnClickListener brZ = new h(this);
    private View.OnLongClickListener bsa = new j(this);
    private com.baidu.tbadk.core.view.a bsb = new k(this);
    private ViewPager.OnPageChangeListener bsc = new l(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010000, new f());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        setContentView(x.image_activity_2);
        initData(bundle);
        JA();
        FX();
        if (!this.brX) {
            String hv = hv(this.brJ);
            if (hv == null) {
                this.aJn.setVisibility(8);
            }
            this.brR = new a(this.brI, this.brV, this.bri, hv);
            this.brR.dn(this.brK);
            this.brR.a(new m(this));
            this.brR.TQ();
        }
    }

    public void PM() {
        try {
            byte[] currentImageData = this.brP.getCurrentImageData();
            if (currentImageData != null) {
                this.brL = new q(this, this.brP.getCurrentImageUrl(), currentImageData);
                this.brL.execute(new String[0]);
                this.brM.setClickable(false);
            } else {
                showToast(getPageContext().getString(z.no_data));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.brP.setBackgroundColor(bc.cc(i));
        } else {
            this.brP.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        TW();
    }

    private void TW() {
        bc.j(this.aJn, t.alpha80_black);
        getLayoutMode().h(this.brN);
        getLayoutMode().h(this.brO);
        getLayoutMode().h(this.brM);
    }

    private void FX() {
        if (this.brX) {
            this.brQ = new p(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.brQ, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.brP.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.brP.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.brP.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
        O(this.mIndex, this.mIndex);
        TY();
        this.brP.onDestroy();
        if (this.brL != null) {
            this.brL.cancel();
            this.brL = null;
        }
        if (this.brX) {
            unregisterReceiver(this.brQ);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra(ImageViewerConfig.INDEX, this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void JA() {
        HN();
        initViewPager();
        TX();
        O(this.mIndex, this.mIndex);
    }

    private void HN() {
        this.aJn = (NavigationBar) findViewById(w.navigation_bar);
        this.brO = this.aJn.setTitleText("");
        this.brN = this.aJn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        this.brM = this.aJn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.image_activity_save_button, (View.OnClickListener) null);
        this.brM.setOnClickListener(new o(this));
        this.aJn.findViewById(w.navBottomLine).setVisibility(8);
    }

    public void TX() {
        String str;
        if (this.brI != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.brH)) + "/";
            if (this.mCount > 0) {
                str = String.valueOf(str2) + this.mCount;
            } else if (!this.brX) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.brI.size();
            }
            if (this.brP.getHasNext() && this.mIndex == this.brP.getItemNum() - 1) {
                this.brO.setText(getPageContext().getString(z.image_recommend));
                this.brM.setClickable(false);
                this.brM.setVisibility(8);
                return;
            }
            this.brO.setText(str);
            this.brM.setClickable(true);
            this.brM.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.brP = (MultiImageView) findViewById(w.viewpager);
        this.brP.setIsFromCDN(this.Ux);
        this.brP.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.brP.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.brP.setOnPageChangeListener(this.bsc);
        this.brP.setUrlData(this.brI);
        this.brP.setItemOnclickListener(this.brZ);
        this.brP.setItemOnLongClickListener(this.bsa);
        this.brP.setCurrentItem(Kg(), false);
        this.brP.setOnScrollOutListener(this.bsb);
        this.brP.setHasNext(this.Uu);
        this.brP.setNextTitle(this.Uv);
    }

    public int Kg() {
        if (this.brI != null && this.brI.size() > 0) {
            int size = this.brI.size();
            if (this.mIndex >= size) {
                this.mIndex = size - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.brI = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mCount = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.Uu = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.Uv = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.brU = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bri = bundle.getString("tid");
            this.brV = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.brW = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.Ux = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.brJ = bundle.getString(ImageViewerConfig.LAST_ID);
            this.brK = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.brI = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mCount = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.Uu = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.Uv = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.brU = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bri = intent.getStringExtra("tid");
                this.brV = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.brW = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.Ux = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.brJ = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.brK = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
            }
        }
        if (getIntent() != null) {
            this.brX = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.brT = new HashMap<>();
        this.mCount = this.brI.size();
        if (this.brJ == null) {
            this.brJ = this.mCount > 0 ? this.brI.get(this.mCount - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.brI);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mCount);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.Uu);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.Uv);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.brU);
        bundle.putString("tid", this.bri);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.brV);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.brW);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.brK);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.brP.setCurrentItem(this.mIndex, false);
    }

    public void O(int i, int i2) {
        synchronized (this.brT) {
            if (System.nanoTime() - this.brS > 300000000 && this.brI != null && i < this.brI.size()) {
                this.brT.put(this.brI.get(i), true);
            }
            this.brS = System.nanoTime();
            if (this.brI != null && i2 < this.brI.size() && this.brT.get(this.brI.get(i2)) == null) {
                this.brT.put(this.brI.get(i2), false);
            }
        }
        if (this.brT.size() >= 100) {
            TY();
        }
    }

    private void TY() {
        if (this.brT != null) {
            synchronized (this.brT) {
                if (this.brT.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.brT.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m255getInst().sendImagePv(i, this.brT.size(), this.brW);
                    this.brT.clear();
                }
            }
        }
    }

    private String hv(String str) {
        int lastIndexOf;
        int indexOf;
        String aF = bf.aF(str);
        if (aF != null) {
            if (aF.indexOf(".baidu.com") != -1 && (lastIndexOf = aF.lastIndexOf("/")) != -1 && (indexOf = aF.indexOf(".", lastIndexOf)) != -1) {
                return aF.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aF;
    }
}
