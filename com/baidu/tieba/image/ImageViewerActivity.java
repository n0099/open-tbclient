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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
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
    private boolean TP;
    private String TQ;
    private boolean TS;
    private NavigationBar aId;
    private boolean aPX;
    private AlphaAnimation akw;
    private String bpK;
    private ArrayList<String> bqk;
    private String bql;
    private q bqn;
    private View bqo;
    private View bqp;
    private TextView bqq;
    private MultiImageView bqr;
    private p bqs;
    private a bqt;
    private HashMap<String, Boolean> bqv;
    private String bqw;
    private String bqx;
    private String bqy;
    private boolean bqz;
    private int bqj = 0;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean bqm = true;
    private boolean aPW = true;
    private long bqu = 0;
    private DialogInterface.OnClickListener bqA = new g(this);
    private View.OnClickListener bqB = new h(this);
    private View.OnLongClickListener bqC = new j(this);
    private com.baidu.tbadk.core.view.a bqD = new k(this);
    private ViewPager.OnPageChangeListener bqE = new l(this);

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
        Jc();
        Fz();
        if (!this.bqz) {
            String ho = ho(this.bql);
            if (ho == null) {
                this.aId.setVisibility(8);
            }
            this.bqt = new a(this.bqk, this.bqx, this.bpK, ho);
            this.bqt.di(this.bqm);
            this.bqt.a(new m(this));
            this.bqt.Tu();
        }
    }

    public void Pp() {
        try {
            byte[] currentImageData = this.bqr.getCurrentImageData();
            if (currentImageData != null) {
                this.bqn = new q(this, this.bqr.getCurrentImageUrl(), currentImageData);
                this.bqn.execute(new String[0]);
                this.bqo.setClickable(false);
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
            this.bqr.setBackgroundColor(ax.bV(i));
        } else {
            this.bqr.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        TA();
    }

    private void TA() {
        ax.j(this.aId, t.alpha80_black);
        getLayoutMode().h(this.bqp);
        getLayoutMode().h(this.bqq);
        getLayoutMode().h(this.bqo);
    }

    private void Fz() {
        if (this.bqz) {
            this.bqs = new p(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.bqs, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bqr.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bqr.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bqr.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
        N(this.mIndex, this.mIndex);
        TC();
        this.bqr.onDestroy();
        if (this.bqn != null) {
            this.bqn.cancel();
            this.bqn = null;
        }
        if (this.bqz) {
            unregisterReceiver(this.bqs);
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

    private void Jc() {
        Hp();
        initViewPager();
        TB();
        N(this.mIndex, this.mIndex);
    }

    private void Hp() {
        this.aId = (NavigationBar) findViewById(w.navigation_bar);
        this.bqq = this.aId.setTitleText("");
        this.bqp = this.aId.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        this.bqo = this.aId.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.image_activity_save_button, (View.OnClickListener) null);
        this.bqo.setOnClickListener(new o(this));
        this.aId.findViewById(w.navBottomLine).setVisibility(8);
    }

    public void TB() {
        String str;
        if (this.bqk != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bqj)) + "/";
            if (this.mCount > 0) {
                str = String.valueOf(str2) + this.mCount;
            } else if (!this.bqz) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bqk.size();
            }
            if (this.bqr.getHasNext() && this.mIndex == this.bqr.getItemNum() - 1) {
                this.bqq.setText(getPageContext().getString(z.image_recommend));
                this.bqo.setClickable(false);
                this.bqo.setVisibility(8);
                return;
            }
            this.bqq.setText(str);
            this.bqo.setClickable(true);
            this.bqo.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.bqr = (MultiImageView) findViewById(w.viewpager);
        this.bqr.setIsFromCDN(this.TS);
        this.bqr.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.bqr.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bqr.setOnPageChangeListener(this.bqE);
        this.bqr.setUrlData(this.bqk);
        this.bqr.setItemOnclickListener(this.bqB);
        this.bqr.setItemOnLongClickListener(this.bqC);
        this.bqr.setCurrentItem(JL(), false);
        this.bqr.setOnScrollOutListener(this.bqD);
        this.bqr.setHasNext(this.TP);
        this.bqr.setNextTitle(this.TQ);
    }

    public int JL() {
        if (this.bqk != null && this.bqk.size() > 0) {
            int size = this.bqk.size();
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
            this.bqk = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mCount = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.TP = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.TQ = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bqw = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bpK = bundle.getString("tid");
            this.bqx = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bqy = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.TS = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bql = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bqm = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bqk = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mCount = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.TP = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.TQ = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bqw = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bpK = intent.getStringExtra("tid");
                this.bqx = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bqy = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.TS = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bql = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bqm = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
            }
        }
        if (getIntent() != null) {
            this.bqz = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bqv = new HashMap<>();
        this.mCount = this.bqk.size();
        if (this.bql == null) {
            this.bql = this.mCount > 0 ? this.bqk.get(this.mCount - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.bqk);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mCount);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.TP);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.TQ);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bqw);
        bundle.putString("tid", this.bpK);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bqx);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bqy);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bqm);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bqr.setCurrentItem(this.mIndex, false);
    }

    public void N(int i, int i2) {
        synchronized (this.bqv) {
            if (System.nanoTime() - this.bqu > 300000000 && this.bqk != null && i < this.bqk.size()) {
                this.bqv.put(this.bqk.get(i), true);
            }
            this.bqu = System.nanoTime();
            if (this.bqk != null && i2 < this.bqk.size() && this.bqv.get(this.bqk.get(i2)) == null) {
                this.bqv.put(this.bqk.get(i2), false);
            }
        }
        if (this.bqv.size() >= 100) {
            TC();
        }
    }

    private void TC() {
        if (this.bqv != null) {
            synchronized (this.bqv) {
                if (this.bqv.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bqv.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m255getInst().sendImagePv(i, this.bqv.size(), this.bqy);
                    this.bqv.clear();
                }
            }
        }
    }

    private String ho(String str) {
        int lastIndexOf;
        int indexOf;
        String aF = ba.aF(str);
        if (aF != null) {
            if (aF.indexOf(".baidu.com") != -1 && (lastIndexOf = aF.lastIndexOf("/")) != -1 && (indexOf = aF.indexOf(".", lastIndexOf)) != -1) {
                return aF.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aF;
    }
}
