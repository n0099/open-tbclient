package com.baidu.tieba.recapp.view;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.t;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView aDt;
    private View mRootView;
    private TextView mTitleTextView;
    private TextView mYP;
    private ImageView mYQ;
    private Button mYU;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aDt = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.mYP = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.mYQ = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.mYU = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.mYO == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str2 = "";
                        if (adPost.getAdvertAppInfo() == null) {
                            str = "";
                        } else {
                            str = adPost.getAdvertAppInfo().extensionInfo;
                            if (adPost.getAdvertAppInfo().blE()) {
                                str2 = TextUtils.isEmpty(adPost.getAdvertAppInfo().eLw) ? adPost.getAdvertAppInfo().eLt : adPost.getAdvertAppInfo().eLw;
                            }
                        }
                        int a2 = t.a(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str2, str);
                        if (AdOperateViewJumpHolder.this.lcA != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.lcA.d(a2, hashMap);
                        }
                    }
                }
            });
            this.mYU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        ap.setViewTextColor(this.mTitleTextView, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.aDt, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.mYP, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.mYU, R.color.CAM_X0302, 3);
        ap.setImageResource(this.mYQ, R.drawable.ad_divider);
        ap.setBackgroundResource(this.mYU, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.aaX);
            if (StringUtils.isNull(aVar.mTB)) {
                this.aDt.setVisibility(8);
            } else {
                this.aDt.setVisibility(0);
                this.aDt.setText(aVar.mTB);
            }
            this.mYP.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.mYO == 2) {
                    this.mYU.setText(getResources().getString(R.string.check_immediately));
                } else if (this.mYO == 1) {
                    this.mYU.setText(getResources().getString(R.string.download));
                } else {
                    this.mYU.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.mYO);
                }
            } else {
                this.mYU.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        String str;
        String str2;
        if (bVar != null) {
            AdPost adPost = (AdPost) getTag();
            if (adPost == null || adPost.getAdvertAppInfo() == null) {
                str = null;
                str2 = null;
            } else {
                String str3 = TextUtils.isEmpty(adPost.getAdvertAppInfo().eLw) ? adPost.getAdvertAppInfo().eLt : adPost.getAdvertAppInfo().eLw;
                str = adPost.getAdvertAppInfo().extensionInfo;
                str2 = str3;
            }
            int a2 = t.a(this.mPageContext, bVar.scheme, str2, str);
            if (t.HL(a2)) {
                if (this.lcA != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.lcA.d(a2, hashMap);
                }
            } else if (this.lcA != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.lcA.b(bVar.mTm, bVar.mTn, hashMap2);
            }
        }
    }
}
