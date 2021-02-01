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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class i {
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> eYI = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.themeCenter.background.i.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.drawImageTo(i.this.nHh);
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
    private TextView joJ;
    private View mRootView;
    private TextView mxR;
    private BackgroundPreviewActivity nHg;
    private BdExpandImageView nHh;
    private TbImageView nHi;
    private TbImageView nHj;
    private ImageView nHk;

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nHg = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.nHg.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.nHg.getResources().getDimensionPixelSize(R.dimen.ds450)));
        initView();
    }

    private void initView() {
        this.nHh = (BdExpandImageView) this.mRootView.findViewById(R.id.expand_image);
        this.nHi = (TbImageView) this.mRootView.findViewById(R.id.user_head);
        this.nHj = (TbImageView) this.mRootView.findViewById(R.id.vip_icon);
        this.nHj.setAutoChangeStyle(false);
        this.joJ = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nHk = (ImageView) this.mRootView.findViewById(R.id.user_sex);
        this.mxR = (TextView) this.mRootView.findViewById(R.id.user_bar_age_num);
        this.nHi.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            com.baidu.adp.lib.e.d.mw().a(dressItemData.getExampleImgUrl(), 10, this.eYI, 0, 0, null, new Object[0]);
            if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
                this.mxR.setText("0");
            } else {
                this.mxR.setText(dressItemData.getPropsStateImg());
            }
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo == null) {
                ap.setViewTextColor(this.mxR, R.color.CAM_X0308, 1);
                this.joJ.setText(R.string.default_user_name);
                this.nHk.setImageResource(R.drawable.icon_pop_boy);
                this.nHj.setVisibility(8);
                return;
            }
            String avatar = currentAccountInfo.getAvatar();
            int memberType = currentAccountInfo.getMemberType();
            if (!TextUtils.isEmpty(avatar)) {
                this.nHi.startLoad(avatar, 25, false);
            }
            String memberIconUrl = currentAccountInfo.getMemberIconUrl();
            if (StringUtils.isNull(memberIconUrl)) {
                this.nHj.setVisibility(8);
            } else {
                this.nHj.startLoad(memberIconUrl, 10, false);
                this.nHj.setVisibility(0);
            }
            if (memberType > 0) {
                this.joJ.setTextColor(this.nHg.getResources().getColor(R.color.CAM_X0308));
            } else {
                this.joJ.setTextColor(this.nHg.getResources().getColor(R.color.CAM_X0111));
            }
            this.joJ.setText(currentAccountInfo.getAccountNameShow());
            int sex = currentAccountInfo.getSex();
            if (sex == 1) {
                this.nHk.setImageResource(R.drawable.icon_pop_boy);
            } else if (sex == 2) {
                this.nHk.setImageResource(R.drawable.icon_pop_girl);
            } else {
                this.nHk.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bzn() {
        if (this.nHg.getPageContext() != null) {
            com.baidu.tbadk.r.a.a(this.nHg.getPageContext(), this.mRootView);
        }
    }
}
