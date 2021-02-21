package com.baidu.tieba.themeCenter.card.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonalCardItemView extends LinearLayout {
    private int eQj;
    private int eQk;
    private TbImageView lme;
    private TbImageView lmf;
    private Context mContext;
    private View mRootView;
    private ImageView nGu;
    private TextView nHT;
    private TbImageView nHj;
    private TextView nIL;
    private View nIM;
    private com.baidu.tieba.themeCenter.a nIN;
    private a nIO;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.themeCenter.a aVar);
    }

    public PersonalCardItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public PersonalCardItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public PersonalCardItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.eQj = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eQk = (int) (this.eQj * 0.57d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.personal_card_item_layout, this);
        this.lme = (TbImageView) this.mRootView.findViewById(R.id.image_bg);
        this.lmf = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lmf.setDefaultResource(R.drawable.transparent_bg);
        this.lmf.setDefaultBgResource(R.drawable.transparent_bg);
        this.nHj = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nHj.setDefaultResource(R.drawable.transparent_bg);
        this.nHj.setDefaultBgResource(R.drawable.transparent_bg);
        this.nGu = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nHT = (TextView) this.mRootView.findViewById(R.id.txt_default);
        this.nIL = (TextView) this.mRootView.findViewById(R.id.view_card_name);
        this.nIM = this.mRootView.findViewById(R.id.black_stroke);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lme.getLayoutParams();
        layoutParams.height = this.eQk;
        layoutParams.width = this.eQj;
        this.lme.setLayoutParams(layoutParams);
        this.nIM.setLayoutParams(layoutParams);
        this.lme.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonalCardItemView.this.nIO != null) {
                    PersonalCardItemView.this.nIO.a(PersonalCardItemView.this.nIN);
                }
            }
        });
    }

    public void b(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nIN = aVar;
            if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nFO) {
                this.lme.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ap.setBackgroundColor(this.lme, R.color.CAM_X0204);
                ap.setImageResource(this.lme, R.drawable.icon_bubble_choose_no);
                this.nHT.setVisibility(0);
                this.nHj.setVisibility(8);
                this.lmf.setVisibility(8);
            } else {
                this.nHT.setVisibility(8);
                this.nHj.setVisibility(0);
                this.lmf.setVisibility(0);
                this.lme.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.lme.setImageBitmap(null);
                this.lme.setDefaultResource(R.drawable.img_default_100);
                this.lme.startLoad(aVar.dQW(), 10, false);
            }
            if (aVar.dQZ() == 1) {
                this.nGu.setVisibility(0);
                ap.setImageResource(this.nGu, R.drawable.icon_choose_photo);
            } else {
                this.nGu.setVisibility(8);
            }
            this.lmf.startLoad(aVar.dQX(), 10, false);
            this.nHj.startLoad(aVar.dQY(), 10, false);
            this.nIL.setText(aVar.getTitle());
            setVisibility(0);
        }
    }

    public a getCardViewController() {
        return this.nIO;
    }

    public void setCardViewController(a aVar) {
        this.nIO = aVar;
    }
}
