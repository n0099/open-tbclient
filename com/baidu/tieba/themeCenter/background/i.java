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
                aVar.drawImageTo(i.this.nHH);
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
    private TextView joX;
    private View mRootView;
    private TextView myg;
    private BackgroundPreviewActivity nHG;
    private BdExpandImageView nHH;
    private TbImageView nHI;
    private TbImageView nHJ;
    private ImageView nHK;

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nHG = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.nHG.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.nHG.getResources().getDimensionPixelSize(R.dimen.ds450)));
        initView();
    }

    private void initView() {
        this.nHH = (BdExpandImageView) this.mRootView.findViewById(R.id.expand_image);
        this.nHI = (TbImageView) this.mRootView.findViewById(R.id.user_head);
        this.nHJ = (TbImageView) this.mRootView.findViewById(R.id.vip_icon);
        this.nHJ.setAutoChangeStyle(false);
        this.joX = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nHK = (ImageView) this.mRootView.findViewById(R.id.user_sex);
        this.myg = (TextView) this.mRootView.findViewById(R.id.user_bar_age_num);
        this.nHI.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            com.baidu.adp.lib.e.d.mw().a(dressItemData.getExampleImgUrl(), 10, this.eYI, 0, 0, null, new Object[0]);
            if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
                this.myg.setText("0");
            } else {
                this.myg.setText(dressItemData.getPropsStateImg());
            }
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo == null) {
                ap.setViewTextColor(this.myg, R.color.CAM_X0308, 1);
                this.joX.setText(R.string.default_user_name);
                this.nHK.setImageResource(R.drawable.icon_pop_boy);
                this.nHJ.setVisibility(8);
                return;
            }
            String avatar = currentAccountInfo.getAvatar();
            int memberType = currentAccountInfo.getMemberType();
            if (!TextUtils.isEmpty(avatar)) {
                this.nHI.startLoad(avatar, 25, false);
            }
            String memberIconUrl = currentAccountInfo.getMemberIconUrl();
            if (StringUtils.isNull(memberIconUrl)) {
                this.nHJ.setVisibility(8);
            } else {
                this.nHJ.startLoad(memberIconUrl, 10, false);
                this.nHJ.setVisibility(0);
            }
            if (memberType > 0) {
                this.joX.setTextColor(this.nHG.getResources().getColor(R.color.CAM_X0308));
            } else {
                this.joX.setTextColor(this.nHG.getResources().getColor(R.color.CAM_X0111));
            }
            this.joX.setText(currentAccountInfo.getAccountNameShow());
            int sex = currentAccountInfo.getSex();
            if (sex == 1) {
                this.nHK.setImageResource(R.drawable.icon_pop_boy);
            } else if (sex == 2) {
                this.nHK.setImageResource(R.drawable.icon_pop_girl);
            } else {
                this.nHK.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bzn() {
        if (this.nHG.getPageContext() != null) {
            com.baidu.tbadk.r.a.a(this.nHG.getPageContext(), this.mRootView);
        }
    }
}
