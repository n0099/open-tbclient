package com.baidu.tieba.recapp.view;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.r;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView aWB;
    private TextView lkM;
    private ImageView lkN;
    private Button lkR;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aWB = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.lkM = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.lkN = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.lkR = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.lkL == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str = null;
                        if (adPost.getAdvertAppInfo() != null) {
                            str = adPost.getAdvertAppInfo().dGL;
                        }
                        int c = r.c(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str);
                        if (AdOperateViewJumpHolder.this.jrl != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.jrl.d(c, hashMap);
                        }
                    }
                }
            });
            this.lkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        an.setViewTextColor(this.mTitleTextView, R.color.cp_cont_j, 1);
        an.setViewTextColor(this.aWB, R.color.cp_cont_j, 1);
        an.setViewTextColor(this.lkM, R.color.cp_cont_f, 1);
        an.setViewTextColor(this.lkR, R.color.cp_link_tip_a, 3);
        an.setImageResource(this.lkN, R.drawable.ad_divider);
        an.setBackgroundResource(this.lkR, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.Ym);
            if (StringUtils.isNull(aVar.lfZ)) {
                this.aWB.setVisibility(8);
            } else {
                this.aWB.setVisibility(0);
                this.aWB.setText(aVar.lfZ);
            }
            this.lkM.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.lkL == 2) {
                    this.lkR.setText(getResources().getString(R.string.check_immediately));
                } else if (this.lkL == 1) {
                    this.lkR.setText(getResources().getString(R.string.download));
                } else {
                    this.lkR.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.lkL);
                }
            } else {
                this.lkR.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        String str;
        if (bVar != null) {
            AdPost adPost = (AdPost) getTag();
            if (adPost == null || adPost.getAdvertAppInfo() == null) {
                str = null;
            } else {
                str = adPost.getAdvertAppInfo().dGL;
            }
            int c = r.c(this.mPageContext, bVar.scheme, str);
            if (c == 1 || c == 2) {
                if (this.jrl != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.jrl.d(c, hashMap);
                }
            } else if (this.jrl != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.jrl.a(bVar.aoJ, bVar.aoK, hashMap2);
            }
        }
    }
}
