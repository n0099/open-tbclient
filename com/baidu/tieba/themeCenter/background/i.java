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
/* loaded from: classes8.dex */
public class i {
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> eWs = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.themeCenter.background.i.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.drawImageTo(i.this.nxx);
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
    private TextView jjc;
    private View mRootView;
    private TextView moR;
    private ImageView nxA;
    private BackgroundPreviewActivity nxw;
    private BdExpandImageView nxx;
    private TbImageView nxy;
    private TbImageView nxz;

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nxw = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.nxw.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.nxw.getResources().getDimensionPixelSize(R.dimen.ds450)));
        initView();
    }

    private void initView() {
        this.nxx = (BdExpandImageView) this.mRootView.findViewById(R.id.expand_image);
        this.nxy = (TbImageView) this.mRootView.findViewById(R.id.user_head);
        this.nxz = (TbImageView) this.mRootView.findViewById(R.id.vip_icon);
        this.nxz.setAutoChangeStyle(false);
        this.jjc = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nxA = (ImageView) this.mRootView.findViewById(R.id.user_sex);
        this.moR = (TextView) this.mRootView.findViewById(R.id.user_bar_age_num);
        this.nxy.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            com.baidu.adp.lib.e.d.mx().a(dressItemData.getExampleImgUrl(), 10, this.eWs, 0, 0, null, new Object[0]);
            if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
                this.moR.setText("0");
            } else {
                this.moR.setText(dressItemData.getPropsStateImg());
            }
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo == null) {
                ao.setViewTextColor(this.moR, R.color.CAM_X0308, 1);
                this.jjc.setText(R.string.default_user_name);
                this.nxA.setImageResource(R.drawable.icon_pop_boy);
                this.nxz.setVisibility(8);
                return;
            }
            String avatar = currentAccountInfo.getAvatar();
            int memberType = currentAccountInfo.getMemberType();
            if (!TextUtils.isEmpty(avatar)) {
                this.nxy.startLoad(avatar, 25, false);
            }
            String memberIconUrl = currentAccountInfo.getMemberIconUrl();
            if (StringUtils.isNull(memberIconUrl)) {
                this.nxz.setVisibility(8);
            } else {
                this.nxz.startLoad(memberIconUrl, 10, false);
                this.nxz.setVisibility(0);
            }
            if (memberType > 0) {
                this.jjc.setTextColor(this.nxw.getResources().getColor(R.color.CAM_X0308));
            } else {
                this.jjc.setTextColor(this.nxw.getResources().getColor(R.color.CAM_X0111));
            }
            this.jjc.setText(currentAccountInfo.getAccountNameShow());
            int sex = currentAccountInfo.getSex();
            if (sex == 1) {
                this.nxA.setImageResource(R.drawable.icon_pop_boy);
            } else if (sex == 2) {
                this.nxA.setImageResource(R.drawable.icon_pop_girl);
            } else {
                this.nxA.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void byV() {
        if (this.nxw.getPageContext() != null) {
            com.baidu.tbadk.r.a.a(this.nxw.getPageContext(), this.mRootView);
        }
    }
}
