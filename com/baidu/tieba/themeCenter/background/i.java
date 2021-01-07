package com.baidu.tieba.themeCenter.background;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class i {
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fba = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.themeCenter.background.i.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.drawImageTo(i.this.nCb);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }
    };
    private TextView jnJ;
    private View mRootView;
    private TextView mtw;
    private BackgroundPreviewActivity nCa;
    private BdExpandImageView nCb;
    private TbImageView nCc;
    private TbImageView nCd;
    private ImageView nCe;

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nCa = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.nCa.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.nCa.getResources().getDimensionPixelSize(R.dimen.ds450)));
        initView();
    }

    private void initView() {
        this.nCb = (BdExpandImageView) this.mRootView.findViewById(R.id.expand_image);
        this.nCc = (TbImageView) this.mRootView.findViewById(R.id.user_head);
        this.nCd = (TbImageView) this.mRootView.findViewById(R.id.vip_icon);
        this.nCd.setAutoChangeStyle(false);
        this.jnJ = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nCe = (ImageView) this.mRootView.findViewById(R.id.user_sex);
        this.mtw = (TextView) this.mRootView.findViewById(R.id.user_bar_age_num);
        this.nCc.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            com.baidu.adp.lib.e.d.mx().a(dressItemData.getExampleImgUrl(), 10, this.fba, 0, 0, null, new Object[0]);
            if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
                this.mtw.setText("0");
            } else {
                this.mtw.setText(dressItemData.getPropsStateImg());
            }
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo == null) {
                ao.setViewTextColor(this.mtw, R.color.CAM_X0308, 1);
                this.jnJ.setText(R.string.default_user_name);
                this.nCe.setImageResource(R.drawable.icon_pop_boy);
                this.nCd.setVisibility(8);
                return;
            }
            String avatar = currentAccountInfo.getAvatar();
            int memberType = currentAccountInfo.getMemberType();
            if (!TextUtils.isEmpty(avatar)) {
                this.nCc.startLoad(avatar, 25, false);
            }
            String memberIconUrl = currentAccountInfo.getMemberIconUrl();
            if (StringUtils.isNull(memberIconUrl)) {
                this.nCd.setVisibility(8);
            } else {
                this.nCd.startLoad(memberIconUrl, 10, false);
                this.nCd.setVisibility(0);
            }
            if (memberType > 0) {
                this.jnJ.setTextColor(this.nCa.getResources().getColor(R.color.CAM_X0308));
            } else {
                this.jnJ.setTextColor(this.nCa.getResources().getColor(R.color.CAM_X0111));
            }
            this.jnJ.setText(currentAccountInfo.getAccountNameShow());
            int sex = currentAccountInfo.getSex();
            if (sex == 1) {
                this.nCe.setImageResource(R.drawable.icon_pop_boy);
            } else if (sex == 2) {
                this.nCe.setImageResource(R.drawable.icon_pop_girl);
            } else {
                this.nCe.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bCP() {
        if (this.nCa.getPageContext() != null) {
            com.baidu.tbadk.r.a.a(this.nCa.getPageContext(), this.mRootView);
        }
    }
}
