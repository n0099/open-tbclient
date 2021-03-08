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
/* loaded from: classes7.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView aET;
    private View mRootView;
    private TextView mTitleTextView;
    private TextView nba;
    private ImageView nbb;
    private Button nbf;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aET = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.nba = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.nbb = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.nbf = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.naZ == 2) {
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
                            if (adPost.getAdvertAppInfo().blG()) {
                                str2 = TextUtils.isEmpty(adPost.getAdvertAppInfo().eMX) ? adPost.getAdvertAppInfo().eMU : adPost.getAdvertAppInfo().eMX;
                            }
                        }
                        int a2 = t.a(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str2, str);
                        if (AdOperateViewJumpHolder.this.leD != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.leD.d(a2, hashMap);
                        }
                    }
                }
            });
            this.nbf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        ap.setViewTextColor(this.aET, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.nba, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.nbf, R.color.CAM_X0302, 3);
        ap.setImageResource(this.nbb, R.drawable.ad_divider);
        ap.setBackgroundResource(this.nbf, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.acu);
            if (StringUtils.isNull(aVar.mVL)) {
                this.aET.setVisibility(8);
            } else {
                this.aET.setVisibility(0);
                this.aET.setText(aVar.mVL);
            }
            this.nba.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.naZ == 2) {
                    this.nbf.setText(getResources().getString(R.string.check_immediately));
                } else if (this.naZ == 1) {
                    this.nbf.setText(getResources().getString(R.string.download));
                } else {
                    this.nbf.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.naZ);
                }
            } else {
                this.nbf.setText(aVar.buttonText);
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
                String str3 = TextUtils.isEmpty(adPost.getAdvertAppInfo().eMX) ? adPost.getAdvertAppInfo().eMU : adPost.getAdvertAppInfo().eMX;
                str = adPost.getAdvertAppInfo().extensionInfo;
                str2 = str3;
            }
            int a2 = t.a(this.mPageContext, bVar.scheme, str2, str);
            if (t.HO(a2)) {
                if (this.leD != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.leD.d(a2, hashMap);
                }
            } else if (this.leD != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.leD.b(bVar.mVs, bVar.mVt, hashMap2);
            }
        }
    }
}
