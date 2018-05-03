package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView ePu;
    private TextView gcZ;
    private ImageView gda;
    private Button gde;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view2) {
        super(tbPageContext, i, view2);
        this.mRootView = view2;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.ePu = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gcZ = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gda = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gde = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.gcY == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.ewj != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.ewj.b(e, hashMap);
                        }
                    }
                }
            });
            this.gde.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        AdOperateViewJumpHolder.this.a(adPost.adData.buttonClick);
                    }
                }
            });
        }
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ak.j(this.mRootView, d.C0126d.cp_bg_line_e);
        ak.c(this.mTitleTextView, d.C0126d.cp_cont_j, 1);
        ak.c(this.ePu, d.C0126d.cp_cont_j, 1);
        ak.c(this.gcZ, d.C0126d.cp_cont_f, 1);
        ak.c(this.gde, d.C0126d.cp_link_tip_a, 3);
        ak.c(this.gda, d.f.ad_divider);
        ak.i(this.gde, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.fYk);
            if (StringUtils.isNull(aVar.fYl)) {
                this.ePu.setVisibility(8);
            } else {
                this.ePu.setVisibility(0);
                this.ePu.setText(aVar.fYl);
            }
            this.gcZ.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.k.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.gcY == 2) {
                    this.gde.setText(getResources().getString(d.k.check_immediately));
                } else if (this.gcY == 1) {
                    this.gde.setText(getResources().getString(d.k.download));
                } else {
                    this.gde.setText(getResources().getString(d.k.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.gcY);
                }
            } else {
                this.gde.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.ewj != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.ewj.b(e, hashMap);
                }
            } else if (this.ewj != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.ewj.b(bVar.LW, bVar.LX, hashMap2);
            }
        }
    }
}
