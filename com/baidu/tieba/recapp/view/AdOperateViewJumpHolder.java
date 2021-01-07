package com.baidu.tieba.recapp.view;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView aGt;
    private View mRootView;
    private TextView mTB;
    private ImageView mTC;
    private Button mTG;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aGt = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.mTB = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.mTC = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.mTG = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.mTA == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str = "";
                        if (adPost.getAdvertAppInfo() != null && adPost.getAdvertAppInfo().bpg()) {
                            str = TextUtils.isEmpty(adPost.getAdvertAppInfo().eNW) ? adPost.getAdvertAppInfo().eNT : adPost.getAdvertAppInfo().eNW;
                        }
                        int c = s.c(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str);
                        if (AdOperateViewJumpHolder.this.kYN != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.kYN.d(c, hashMap);
                        }
                    }
                }
            });
            this.mTG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        ao.setViewTextColor(this.mTitleTextView, R.color.CAM_X0107, 1);
        ao.setViewTextColor(this.aGt, R.color.CAM_X0107, 1);
        ao.setViewTextColor(this.mTB, R.color.CAM_X0106, 1);
        ao.setViewTextColor(this.mTG, R.color.CAM_X0302, 3);
        ao.setImageResource(this.mTC, R.drawable.ad_divider);
        ao.setBackgroundResource(this.mTG, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.abe);
            if (StringUtils.isNull(aVar.mOu)) {
                this.aGt.setVisibility(8);
            } else {
                this.aGt.setVisibility(0);
                this.aGt.setText(aVar.mOu);
            }
            this.mTB.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.mTA == 2) {
                    this.mTG.setText(getResources().getString(R.string.check_immediately));
                } else if (this.mTA == 1) {
                    this.mTG.setText(getResources().getString(R.string.download));
                } else {
                    this.mTG.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.mTA);
                }
            } else {
                this.mTG.setText(aVar.buttonText);
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
                str = TextUtils.isEmpty(adPost.getAdvertAppInfo().eNW) ? adPost.getAdvertAppInfo().eNT : adPost.getAdvertAppInfo().eNW;
            }
            int c = s.c(this.mPageContext, bVar.scheme, str);
            if (c == 1 || c == 2) {
                if (this.kYN != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.kYN.d(c, hashMap);
                }
            } else if (this.kYN != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.kYN.a(bVar.mOg, bVar.mOh, hashMap2);
            }
        }
    }
}
