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
/* loaded from: classes8.dex */
public class i {
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fah = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.themeCenter.background.i.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.drawImageTo(i.this.nJN);
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
    private TextView jqG;
    private TextView mAi;
    private View mRootView;
    private BackgroundPreviewActivity nJM;
    private BdExpandImageView nJN;
    private TbImageView nJO;
    private TbImageView nJP;
    private ImageView nJQ;

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.nJM = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.nJM.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.nJM.getResources().getDimensionPixelSize(R.dimen.ds450)));
        initView();
    }

    private void initView() {
        this.nJN = (BdExpandImageView) this.mRootView.findViewById(R.id.expand_image);
        this.nJO = (TbImageView) this.mRootView.findViewById(R.id.user_head);
        this.nJP = (TbImageView) this.mRootView.findViewById(R.id.vip_icon);
        this.nJP.setAutoChangeStyle(false);
        this.jqG = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nJQ = (ImageView) this.mRootView.findViewById(R.id.user_sex);
        this.mAi = (TextView) this.mRootView.findViewById(R.id.user_bar_age_num);
        this.nJO.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            com.baidu.adp.lib.e.d.mw().a(dressItemData.getExampleImgUrl(), 10, this.fah, 0, 0, null, new Object[0]);
            if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
                this.mAi.setText("0");
            } else {
                this.mAi.setText(dressItemData.getPropsStateImg());
            }
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo == null) {
                ap.setViewTextColor(this.mAi, R.color.CAM_X0308, 1);
                this.jqG.setText(R.string.default_user_name);
                this.nJQ.setImageResource(R.drawable.icon_pop_boy);
                this.nJP.setVisibility(8);
                return;
            }
            String avatar = currentAccountInfo.getAvatar();
            int memberType = currentAccountInfo.getMemberType();
            if (!TextUtils.isEmpty(avatar)) {
                this.nJO.startLoad(avatar, 25, false);
            }
            String memberIconUrl = currentAccountInfo.getMemberIconUrl();
            if (StringUtils.isNull(memberIconUrl)) {
                this.nJP.setVisibility(8);
            } else {
                this.nJP.startLoad(memberIconUrl, 10, false);
                this.nJP.setVisibility(0);
            }
            if (memberType > 0) {
                this.jqG.setTextColor(this.nJM.getResources().getColor(R.color.CAM_X0308));
            } else {
                this.jqG.setTextColor(this.nJM.getResources().getColor(R.color.CAM_X0111));
            }
            this.jqG.setText(currentAccountInfo.getAccountNameShow());
            int sex = currentAccountInfo.getSex();
            if (sex == 1) {
                this.nJQ.setImageResource(R.drawable.icon_pop_boy);
            } else if (sex == 2) {
                this.nJQ.setImageResource(R.drawable.icon_pop_girl);
            } else {
                this.nJQ.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bzq() {
        if (this.nJM.getPageContext() != null) {
            com.baidu.tbadk.r.a.a(this.nJM.getPageContext(), this.mRootView);
        }
    }
}
