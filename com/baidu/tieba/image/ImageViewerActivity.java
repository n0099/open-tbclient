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
    private boolean Ur;
    private String Us;
    private boolean Uu;
    private NavigationBar aJk;
    private boolean aRb;
    private AlphaAnimation akW;
    private ArrayList<String> brH;
    private String brI;
    private q brK;
    private View brL;
    private View brM;
    private TextView brN;
    private MultiImageView brO;
    private p brP;
    private a brQ;
    private HashMap<String, Boolean> brS;
    private String brT;
    private String brU;
    private String brV;
    private boolean brW;
    private String brh;
    private int brG = 0;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean brJ = true;
    private boolean aRa = true;
    private long brR = 0;
    private DialogInterface.OnClickListener brX = new g(this);
    private View.OnClickListener brY = new h(this);
    private View.OnLongClickListener brZ = new j(this);
    private com.baidu.tbadk.core.view.a bsa = new k(this);
    private ViewPager.OnPageChangeListener bsb = new l(this);

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
        Jv();
        FR();
        if (!this.brW) {
            String hs = hs(this.brI);
            if (hs == null) {
                this.aJk.setVisibility(8);
            }
            this.brQ = new a(this.brH, this.brU, this.brh, hs);
            this.brQ.dn(this.brJ);
            this.brQ.a(new m(this));
            this.brQ.TL();
        }
    }

    public void PH() {
        try {
            byte[] currentImageData = this.brO.getCurrentImageData();
            if (currentImageData != null) {
                this.brK = new q(this, this.brO.getCurrentImageUrl(), currentImageData);
                this.brK.execute(new String[0]);
                this.brL.setClickable(false);
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
            this.brO.setBackgroundColor(bc.cc(i));
        } else {
            this.brO.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        TR();
    }

    private void TR() {
        bc.j(this.aJk, t.alpha80_black);
        getLayoutMode().h(this.brM);
        getLayoutMode().h(this.brN);
        getLayoutMode().h(this.brL);
    }

    private void FR() {
        if (this.brW) {
            this.brP = new p(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.brP, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.brO.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.brO.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.brO.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
        P(this.mIndex, this.mIndex);
        TT();
        this.brO.onDestroy();
        if (this.brK != null) {
            this.brK.cancel();
            this.brK = null;
        }
        if (this.brW) {
            unregisterReceiver(this.brP);
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

    private void Jv() {
        HH();
        initViewPager();
        TS();
        P(this.mIndex, this.mIndex);
    }

    private void HH() {
        this.aJk = (NavigationBar) findViewById(w.navigation_bar);
        this.brN = this.aJk.setTitleText("");
        this.brM = this.aJk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        this.brL = this.aJk.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.image_activity_save_button, (View.OnClickListener) null);
        this.brL.setOnClickListener(new o(this));
        this.aJk.findViewById(w.navBottomLine).setVisibility(8);
    }

    public void TS() {
        String str;
        if (this.brH != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.brG)) + "/";
            if (this.mCount > 0) {
                str = String.valueOf(str2) + this.mCount;
            } else if (!this.brW) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.brH.size();
            }
            if (this.brO.getHasNext() && this.mIndex == this.brO.getItemNum() - 1) {
                this.brN.setText(getPageContext().getString(z.image_recommend));
                this.brL.setClickable(false);
                this.brL.setVisibility(8);
                return;
            }
            this.brN.setText(str);
            this.brL.setClickable(true);
            this.brL.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.brO = (MultiImageView) findViewById(w.viewpager);
        this.brO.setIsFromCDN(this.Uu);
        this.brO.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.brO.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.brO.setOnPageChangeListener(this.bsb);
        this.brO.setUrlData(this.brH);
        this.brO.setItemOnclickListener(this.brY);
        this.brO.setItemOnLongClickListener(this.brZ);
        this.brO.setCurrentItem(Kb(), false);
        this.brO.setOnScrollOutListener(this.bsa);
        this.brO.setHasNext(this.Ur);
        this.brO.setNextTitle(this.Us);
    }

    public int Kb() {
        if (this.brH != null && this.brH.size() > 0) {
            int size = this.brH.size();
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
            this.brH = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mCount = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.Ur = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.Us = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.brT = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.brh = bundle.getString("tid");
            this.brU = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.brV = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.Uu = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.brI = bundle.getString(ImageViewerConfig.LAST_ID);
            this.brJ = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.brH = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mCount = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.Ur = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.Us = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.brT = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.brh = intent.getStringExtra("tid");
                this.brU = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.brV = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.Uu = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.brI = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.brJ = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
            }
        }
        if (getIntent() != null) {
            this.brW = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.brS = new HashMap<>();
        this.mCount = this.brH.size();
        if (this.brI == null) {
            this.brI = this.mCount > 0 ? this.brH.get(this.mCount - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.brH);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mCount);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.Ur);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.Us);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.brT);
        bundle.putString("tid", this.brh);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.brU);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.brV);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.brJ);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.brO.setCurrentItem(this.mIndex, false);
    }

    public void P(int i, int i2) {
        synchronized (this.brS) {
            if (System.nanoTime() - this.brR > 300000000 && this.brH != null && i < this.brH.size()) {
                this.brS.put(this.brH.get(i), true);
            }
            this.brR = System.nanoTime();
            if (this.brH != null && i2 < this.brH.size() && this.brS.get(this.brH.get(i2)) == null) {
                this.brS.put(this.brH.get(i2), false);
            }
        }
        if (this.brS.size() >= 100) {
            TT();
        }
    }

    private void TT() {
        if (this.brS != null) {
            synchronized (this.brS) {
                if (this.brS.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.brS.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m255getInst().sendImagePv(i, this.brS.size(), this.brV);
                    this.brS.clear();
                }
            }
        }
    }

    private String hs(String str) {
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
