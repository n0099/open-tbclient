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
/* loaded from: classes8.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView aDt;
    private View mRootView;
    private TextView mTitleTextView;
    private TextView mYp;
    private ImageView mYq;
    private Button mYu;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aDt = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.mYp = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.mYq = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.mYu = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.mYo == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str = "";
                        if (adPost.getAdvertAppInfo() != null && adPost.getAdvertAppInfo().blE()) {
                            str = TextUtils.isEmpty(adPost.getAdvertAppInfo().eLx) ? adPost.getAdvertAppInfo().eLu : adPost.getAdvertAppInfo().eLx;
                        }
                        int c = s.c(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str);
                        if (AdOperateViewJumpHolder.this.lcl != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.lcl.d(c, hashMap);
                        }
                    }
                }
            });
            this.mYu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        ap.setViewTextColor(this.mYp, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.mYu, R.color.CAM_X0302, 3);
        ap.setImageResource(this.mYq, R.drawable.ad_divider);
        ap.setBackgroundResource(this.mYu, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.aaX);
            if (StringUtils.isNull(aVar.mSZ)) {
                this.aDt.setVisibility(8);
            } else {
                this.aDt.setVisibility(0);
                this.aDt.setText(aVar.mSZ);
            }
            this.mYp.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.mYo == 2) {
                    this.mYu.setText(getResources().getString(R.string.check_immediately));
                } else if (this.mYo == 1) {
                    this.mYu.setText(getResources().getString(R.string.download));
                } else {
                    this.mYu.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.mYo);
                }
            } else {
                this.mYu.setText(aVar.buttonText);
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
                str = TextUtils.isEmpty(adPost.getAdvertAppInfo().eLx) ? adPost.getAdvertAppInfo().eLu : adPost.getAdvertAppInfo().eLx;
            }
            int c = s.c(this.mPageContext, bVar.scheme, str);
            if (s.HL(c)) {
                if (this.lcl != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.lcl.d(c, hashMap);
                }
            } else if (this.lcl != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.lcl.b(bVar.mSK, bVar.mSL, hashMap2);
            }
        }
    }
}
