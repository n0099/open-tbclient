package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView hob;
    private TextView iFO;
    private ImageView iFP;
    private Button iFT;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.hob = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.iFO = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.iFP = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.iFT = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.iFN == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.gYK != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.gYK.b(e, hashMap);
                        }
                    }
                }
            });
            this.iFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
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
        al.l(this.mRootView, R.color.cp_bg_line_e);
        al.f(this.mTitleTextView, R.color.cp_cont_j, 1);
        al.f(this.hob, R.color.cp_cont_j, 1);
        al.f(this.iFO, R.color.cp_cont_f, 1);
        al.f(this.iFT, R.color.cp_link_tip_a, 3);
        al.c(this.iFP, (int) R.drawable.ad_divider);
        al.k(this.iFT, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.RE);
            if (StringUtils.isNull(aVar.iAS)) {
                this.hob.setVisibility(8);
            } else {
                this.hob.setVisibility(0);
                this.hob.setText(aVar.iAS);
            }
            this.iFO.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.iFN == 2) {
                    this.iFT.setText(getResources().getString(R.string.check_immediately));
                } else if (this.iFN == 1) {
                    this.iFT.setText(getResources().getString(R.string.download));
                } else {
                    this.iFT.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.iFN);
                }
            } else {
                this.iFT.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.gYK != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.gYK.b(e, hashMap);
                }
            } else if (this.gYK != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.gYK.b(bVar.abk, bVar.abl, hashMap2);
            }
        }
    }
}
