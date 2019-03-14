package com.baidu.tieba.recapp.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class AdOperateViewDownloadHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewDownloadHolder.class.getSimpleName();
    private TextView gWS;
    protected CustomMessageListener iiX;
    private String ilZ;
    private TextView inn;
    private ImageView ino;
    private ApkDownloadView inp;
    private a mPermissionJudgePolicy;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewDownloadHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.iiX = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdOperateViewDownloadHolder.this.ilZ) && AdOperateViewDownloadHolder.this.ilZ.equals(downloadData.getId())) {
                    AdOperateViewDownloadHolder.this.inp.s(downloadData);
                }
            }
        };
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.gWS = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.inn = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.ino = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.inp = (ApkDownloadView) this.mRootView.findViewById(d.g.ad_operate_action);
        this.inp.q(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.iiX);
        this.iiX.setTag(this.mPageContext.getUniqueId());
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.l(this.mRootView, d.C0277d.cp_bg_line_e);
        al.d(this.mTitleTextView, d.C0277d.cp_cont_j, 1);
        al.d(this.gWS, d.C0277d.cp_cont_j, 1);
        al.d(this.inn, d.C0277d.cp_cont_f, 1);
        al.c(this.ino, d.f.ad_divider);
        al.d(this.inp, d.C0277d.cp_link_tip_a, 3);
        al.k(this.inp, d.f.btn_focus_border_bg);
        this.inp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewDownloadHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.TV);
            if (StringUtils.isNull(aVar.iiq)) {
                this.gWS.setVisibility(8);
            } else {
                this.gWS.setVisibility(0);
                this.gWS.setText(aVar.iiq);
            }
            this.inn.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            AdClick adClick = new AdClick(adPost);
            this.mRootView.setOnClickListener(adClick);
            this.inp.setOnClickListener(adClick);
            this.inp.setVisibility(0);
            AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.Xb()) {
                this.ilZ = advertAppInfo.bwH;
                DownloadData c = c(adPost.getAdvertAppInfo(), b.l(adPost.getAdvertAppInfo().adPosition, -1));
                c.setStatus(ApkDownloadView.getStatus(c));
                this.inp.setData(c);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwH);
        downloadData.setUrl(advertAppInfo.bwG);
        downloadData.setName(advertAppInfo.bwE);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.bwD, 0));
        return downloadData;
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.Xa() != 0) {
                l.showToast(this.mPageContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new a();
            }
            this.mPermissionJudgePolicy.adQ();
            this.mPermissionJudgePolicy.e(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mPageContext.getPageActivity()) && this.gHz != null) {
                this.gHz.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mPageContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.Xb()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mPageContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                aVar.ly(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, i, AdOperateViewDownloadHolder.this.inp);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.AdOperateViewDownloadHolder.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mPageContext).aaZ();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData c = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c)) {
                case 1:
                case 5:
                    if (z) {
                        g.f(advertAppInfo);
                        apkDownloadView.q(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    s.aR(this.mPageContext.getPageActivity(), advertAppInfo.bwH);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, apkDownloadView);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class AdClick implements View.OnClickListener {
        private AdPost inr;

        public AdClick(AdPost adPost) {
            this.inr = adPost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdOperateViewDownloadHolder.this.mPageContext.showToast(d.j.neterror);
            } else if (this.inr != null) {
                AdvertAppInfo advertAppInfo = this.inr.getAdvertAppInfo();
                boolean z = view == AdOperateViewDownloadHolder.this.inp;
                if (advertAppInfo != null && advertAppInfo.Xb()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdOperateViewDownloadHolder.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                        AdOperateViewDownloadHolder.this.a(advertAppInfo, l, AdOperateViewDownloadHolder.this.inp, z);
                        if (AdOperateViewDownloadHolder.this.gHy != null) {
                            AdOperateViewDownloadHolder.this.gHy.b(3, null);
                            return;
                        }
                        return;
                    }
                    AdOperateViewDownloadHolder.this.showDownloadAppDialog(advertAppInfo, l, true, this.inr.getAdvertAppInfo().bwN.bwZ);
                }
            }
        }
    }
}
