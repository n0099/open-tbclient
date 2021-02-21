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
    private HeadImageView oIg;
    private RelativeLayout oLA;
    private RelativeLayout oLB;
    private int oLC;
    private SimpleDraweeView oLv;
    private TextView oLw;
    private TextView oLx;
    private a oLy;
    private LinearLayout oLz;

    /* loaded from: classes11.dex */
    public interface a {
        void WC(String str);

        void edL();
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
        this.oIg = (HeadImageView) findViewById(a.f.user_avatar);
        this.oLv = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.oLw = (TextView) findViewById(a.f.new_frame_name);
        this.oLx = (TextView) findViewById(a.f.wear_new_frame);
        this.oLz = (LinearLayout) findViewById(a.f.frame_info_container);
        this.oLA = (RelativeLayout) findViewById(a.f.frame_head_container);
        this.oLB = (RelativeLayout) findViewById(a.f.close_btn);
    }

    private void initListener() {
        this.oLB.setOnClickListener(this);
        this.oLx.setOnClickListener(this);
    }

    public void setNewPhoneFrameInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.optString("content_type");
                this.oLC = jSONObject.optInt("frame_id");
                jSONObject.optString("user_name");
                jSONObject.optString("user_nickname");
                String optString = jSONObject.optString("user_portrait");
                String optString2 = jSONObject.optString("frame_name");
                String optString3 = jSONObject.optString("frame_icon");
                String optString4 = jSONObject.optString("frame_jumpurl");
                WR(optString);
                String str2 = "【" + optString2 + "】";
                if (!TextUtils.isEmpty(optString2)) {
                    this.oLw.setText(StringHelper.highLightText(String.format(getContext().getString(a.h.yuyin_ala_new_frame_name_text), str2), str2, a.c.sdk_color_FFB280, false));
                }
                if (TextUtils.isEmpty(optString3)) {
                    this.oLv.setVisibility(8);
                } else {
                    String str3 = (String) this.oLv.getTag();
                    if (this.oLv.getVisibility() != 0 || !optString3.equals(str3)) {
                        this.oLv.setVisibility(0);
                        a(this.oLv, optString3);
                        this.oLv.setTag(optString3);
                    }
                }
                this.oLv.setTag(optString4);
                this.oLx.setTag(optString4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str) {
        simpleDraweeView.setController(c.etw().bo(ImageRequest.ZL(str)).Bm(true).c(simpleDraweeView.getController()).eun());
    }

    private void WR(String str) {
        this.oIg.setScaleType(ImageView.ScaleType.FIT_XY);
        this.oIg.setImageResource(0);
        this.oIg.setBackgroundResource(0);
        this.oIg.setIsRound(true);
        this.oIg.setDrawBorder(false);
        this.oIg.setAutoChangeStyle(false);
        this.oIg.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.oIg.setUrl(str);
        this.oIg.startLoad(str, 12, false, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oLx) {
            if (this.oLy != null) {
                this.oLy.WC((String) view.getTag());
            }
        } else if (view == this.oLB && this.oLy != null) {
            this.oLy.edL();
        }
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= 20) {
            this.oLA.setAlpha((i * 1.0f) / 20.0f);
        } else if (i >= 20 && i <= 460) {
            this.oLA.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oLA.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oLA.setAlpha(0.0f);
        }
        if (i >= 0 && i <= 24) {
            this.oLz.setAlpha(0.0f);
        } else if (i >= 24 && i <= 60) {
            this.oLz.setAlpha(((i - 24) * 1.0f) / 36.0f);
        } else if (i >= 60 && i <= 460) {
            this.oLz.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oLz.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oLz.setAlpha(1.0f);
        }
        if (i >= 0 && i <= 160) {
            this.oLB.setAlpha(0.0f);
        } else if (i >= 160 && i <= 200) {
            this.oLB.setAlpha(((i - 160) * 1.0f) / 40.0f);
        } else if (i >= 200 && i <= 460) {
            this.oLB.setAlpha(1.0f);
        } else if (i >= 460 && i <= 530) {
            this.oLB.setAlpha(((530 - i) * 1.0f) / 70.0f);
        } else {
            this.oLB.setAlpha(1.0f);
        }
    }

    public void efg() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.oLA, "scaleX", 0.0f, 1.25f, 0.8f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.oLA, "scaleY", 0.0f, 1.25f, 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(1000L);
        animatorSet.start();
    }

    public void setListener(a aVar) {
        this.oLy = aVar;
    }

    public int getFrameId() {
        return this.oLC;
    }
}
