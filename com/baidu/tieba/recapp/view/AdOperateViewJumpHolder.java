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
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes26.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView aGc;
    private TextView mOq;
    private ImageView mOr;
    private Button mOv;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aGc = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.mOq = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.mOr = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.mOv = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.mOp == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str = null;
                        if (adPost.getAdvertAppInfo() != null) {
                            str = TextUtils.isEmpty(adPost.getAdvertAppInfo().eEg) ? adPost.getAdvertAppInfo().eEd : adPost.getAdvertAppInfo().eEg;
                        }
                        int c = s.c(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str);
                        if (AdOperateViewJumpHolder.this.kTj != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.kTj.d(c, hashMap);
                        }
                    }
                }
            });
            this.mOv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        ap.setViewTextColor(this.aGc, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.mOq, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.mOv, R.color.CAM_X0302, 3);
        ap.setImageResource(this.mOr, R.drawable.ad_divider);
        ap.setBackgroundResource(this.mOv, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.aau);
            if (StringUtils.isNull(aVar.mJn)) {
                this.aGc.setVisibility(8);
            } else {
                this.aGc.setVisibility(0);
                this.aGc.setText(aVar.mJn);
            }
            this.mOq.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.mOp == 2) {
                    this.mOv.setText(getResources().getString(R.string.check_immediately));
                } else if (this.mOp == 1) {
                    this.mOv.setText(getResources().getString(R.string.download));
                } else {
                    this.mOv.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.mOp);
                }
            } else {
                this.mOv.setText(aVar.buttonText);
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
                str = TextUtils.isEmpty(adPost.getAdvertAppInfo().eEg) ? adPost.getAdvertAppInfo().eEd : adPost.getAdvertAppInfo().eEg;
            }
            int c = s.c(this.mPageContext, bVar.scheme, str);
            if (c == 1 || c == 2) {
                if (this.kTj != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.kTj.d(c, hashMap);
                }
            } else if (this.kTj != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.kTj.a(bVar.mIZ, bVar.mJa, hashMap2);
            }
        }
    }
}
