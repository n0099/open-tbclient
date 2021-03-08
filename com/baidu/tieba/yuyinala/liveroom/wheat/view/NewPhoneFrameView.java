package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.baidu.live.view.SafeFrameLayout;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.request.ImageRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class NewPhoneFrameView extends SafeFrameLayout implements View.OnClickListener {
    private HeadImageView oKl;
    private SimpleDraweeView oNA;
    private TextView oNB;
    private TextView oNC;
    private a oND;
    private LinearLayout oNE;
    private RelativeLayout oNF;
    private RelativeLayout oNG;
    private int oNH;

    /* loaded from: classes10.dex */
    public interface a {
        void WJ(String str);

        void edT();
    }

    public NewPhoneFrameView(@NonNull Context context) {
        this(context, null);
    }

    public NewPhoneFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPhoneFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
        initListener();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_new_phone_frame_view_layout, this);
        this.oKl = (HeadImageView) findViewById(a.f.user_avatar);
        this.oNA = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.oNB = (TextView) findViewById(a.f.new_frame_name);
        this.oNC = (TextView) findViewById(a.f.wear_new_frame);
        this.oNE = (LinearLayout) findViewById(a.f.frame_info_container);
        this.oNF = (RelativeLayout) findViewById(a.f.frame_head_container);
        this.oNG = (RelativeLayout) findViewById(a.f.close_btn);
    }

    private void initListener() {
        this.oNG.setOnClickListener(this);
        this.oNC.setOnClickListener(this);
    }

    public void setNewPhoneFrameInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.optString("content_type");
                this.oNH = jSONObject.optInt("frame_id");
                jSONObject.optString("user_name");
                jSONObject.optString("user_nickname");
                String optString = jSONObject.optString("user_portrait");
                String optString2 = jSONObject.optString("frame_name");
                String optString3 = jSONObject.optString("frame_icon");
                String optString4 = jSONObject.optString("frame_jumpurl");
                WY(optString);
                String str2 = "【" + optString2 + "】";
                if (!TextUtils.isEmpty(optString2)) {
                    this.oNB.setText(StringHelper.highLightText(String.format(getContext().getString(a.h.yuyin_ala_new_frame_name_text), str2), str2, a.c.sdk_color_FFB280, false));
                }
                if (TextUtils.isEmpty(optString3)) {
                    this.oNA.setVisibility(8);
                } else {
                    String str3 = (String) this.oNA.getTag();
                    if (this.oNA.getVisibility() != 0 || !optString3.equals(str3)) {
                        this.oNA.setVisibility(0);
                        a(this.oNA, optString3);
                        this.oNA.setTag(optString3);
                    }
                }
                this.oNA.setTag(optString4);
                this.oNC.setTag(optString4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str) {
        simpleDraweeView.setController(c.etF().bq(ImageRequest.ZR(str)).Bk(true).c(simpleDraweeView.getController()).euw());
    }

    private void WY(String str) {
        this.oKl.setScaleType(ImageView.ScaleType.FIT_XY);
        this.oKl.setImageResource(0);
        this.oKl.setBackgroundResource(0);
        this.oKl.setIsRound(true);
        this.oKl.setDrawBorder(false);
        this.oKl.setAutoChangeStyle(false);
        this.oKl.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.oKl.setUrl(str);
        this.oKl.startLoad(str, 12, false, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oNC) {
            if (this.oND != null) {
                this.oND.WJ((String) view.getTag());
            }
        } else if (view == this.oNG && this.oND != null) {
            this.oND.edT();
        }
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= 20) {
            this.oNF.setAlpha((i * 1.0f) / 20.0f);
        } else if (i >= 20 && i <= 460) {
            this.oNF.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oNF.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oNF.setAlpha(0.0f);
        }
        if (i >= 0 && i <= 24) {
            this.oNE.setAlpha(0.0f);
        } else if (i >= 24 && i <= 60) {
            this.oNE.setAlpha(((i - 24) * 1.0f) / 36.0f);
        } else if (i >= 60 && i <= 460) {
            this.oNE.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oNE.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oNE.setAlpha(1.0f);
        }
        if (i >= 0 && i <= 160) {
            this.oNG.setAlpha(0.0f);
        } else if (i >= 160 && i <= 200) {
            this.oNG.setAlpha(((i - 160) * 1.0f) / 40.0f);
        } else if (i >= 200 && i <= 460) {
            this.oNG.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oNG.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oNG.setAlpha(1.0f);
        }
    }

    public void efo() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.oNF, "scaleX", 0.0f, 1.25f, 0.8f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.oNF, "scaleY", 0.0f, 1.25f, 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(1000L);
        animatorSet.start();
    }

    public void setListener(a aVar) {
        this.oND = aVar;
    }

    public int getFrameId() {
        return this.oNH;
    }
}
