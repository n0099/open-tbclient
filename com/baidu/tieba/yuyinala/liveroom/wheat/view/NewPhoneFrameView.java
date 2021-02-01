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
/* loaded from: classes11.dex */
public class NewPhoneFrameView extends SafeFrameLayout implements View.OnClickListener {
    private HeadImageView oHG;
    private SimpleDraweeView oKV;
    private TextView oKW;
    private TextView oKX;
    private a oKY;
    private LinearLayout oKZ;
    private RelativeLayout oLa;
    private RelativeLayout oLb;
    private int oLc;

    /* loaded from: classes11.dex */
    public interface a {
        void Wq(String str);

        void edD();
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
        this.oHG = (HeadImageView) findViewById(a.f.user_avatar);
        this.oKV = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.oKW = (TextView) findViewById(a.f.new_frame_name);
        this.oKX = (TextView) findViewById(a.f.wear_new_frame);
        this.oKZ = (LinearLayout) findViewById(a.f.frame_info_container);
        this.oLa = (RelativeLayout) findViewById(a.f.frame_head_container);
        this.oLb = (RelativeLayout) findViewById(a.f.close_btn);
    }

    private void initListener() {
        this.oLb.setOnClickListener(this);
        this.oKX.setOnClickListener(this);
    }

    public void setNewPhoneFrameInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.optString("content_type");
                this.oLc = jSONObject.optInt("frame_id");
                jSONObject.optString("user_name");
                jSONObject.optString("user_nickname");
                String optString = jSONObject.optString("user_portrait");
                String optString2 = jSONObject.optString("frame_name");
                String optString3 = jSONObject.optString("frame_icon");
                String optString4 = jSONObject.optString("frame_jumpurl");
                WF(optString);
                String str2 = "【" + optString2 + "】";
                if (!TextUtils.isEmpty(optString2)) {
                    this.oKW.setText(StringHelper.highLightText(String.format(getContext().getString(a.h.yuyin_ala_new_frame_name_text), str2), str2, a.c.sdk_color_FFB280, false));
                }
                if (TextUtils.isEmpty(optString3)) {
                    this.oKV.setVisibility(8);
                } else {
                    String str3 = (String) this.oKV.getTag();
                    if (this.oKV.getVisibility() != 0 || !optString3.equals(str3)) {
                        this.oKV.setVisibility(0);
                        a(this.oKV, optString3);
                        this.oKV.setTag(optString3);
                    }
                }
                this.oKV.setTag(optString4);
                this.oKX.setTag(optString4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str) {
        simpleDraweeView.setController(c.eto().bo(ImageRequest.Zz(str)).Bm(true).c(simpleDraweeView.getController()).euf());
    }

    private void WF(String str) {
        this.oHG.setScaleType(ImageView.ScaleType.FIT_XY);
        this.oHG.setImageResource(0);
        this.oHG.setBackgroundResource(0);
        this.oHG.setIsRound(true);
        this.oHG.setDrawBorder(false);
        this.oHG.setAutoChangeStyle(false);
        this.oHG.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.oHG.setUrl(str);
        this.oHG.startLoad(str, 12, false, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oKX) {
            if (this.oKY != null) {
                this.oKY.Wq((String) view.getTag());
            }
        } else if (view == this.oLb && this.oKY != null) {
            this.oKY.edD();
        }
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= 20) {
            this.oLa.setAlpha((i * 1.0f) / 20.0f);
        } else if (i >= 20 && i <= 460) {
            this.oLa.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oLa.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oLa.setAlpha(0.0f);
        }
        if (i >= 0 && i <= 24) {
            this.oKZ.setAlpha(0.0f);
        } else if (i >= 24 && i <= 60) {
            this.oKZ.setAlpha(((i - 24) * 1.0f) / 36.0f);
        } else if (i >= 60 && i <= 460) {
            this.oKZ.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oKZ.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oKZ.setAlpha(1.0f);
        }
        if (i >= 0 && i <= 160) {
            this.oLb.setAlpha(0.0f);
        } else if (i >= 160 && i <= 200) {
            this.oLb.setAlpha(((i - 160) * 1.0f) / 40.0f);
        } else if (i >= 200 && i <= 460) {
            this.oLb.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oLb.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oLb.setAlpha(1.0f);
        }
    }

    public void eeY() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.oLa, "scaleX", 0.0f, 1.25f, 0.8f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.oLa, "scaleY", 0.0f, 1.25f, 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(1000L);
        animatorSet.start();
    }

    public void setListener(a aVar) {
        this.oKY = aVar;
    }

    public int getFrameId() {
        return this.oLc;
    }
}
