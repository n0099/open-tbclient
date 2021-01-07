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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonalCardItemView extends LinearLayout {
    private int eSI;
    private int eSJ;
    private TbImageView lit;
    private TbImageView liu;
    private Context mContext;
    private View mRootView;
    private ImageView nAO;
    private TbImageView nBD;
    private TextView nCn;
    private TextView nDf;
    private View nDg;
    private com.baidu.tieba.themeCenter.a nDh;
    private a nDi;

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
        this.eSI = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eSJ = (int) (this.eSI * 0.57d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.personal_card_item_layout, this);
        this.lit = (TbImageView) this.mRootView.findViewById(R.id.image_bg);
        this.liu = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.liu.setDefaultResource(R.drawable.transparent_bg);
        this.liu.setDefaultBgResource(R.drawable.transparent_bg);
        this.nBD = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nBD.setDefaultResource(R.drawable.transparent_bg);
        this.nBD.setDefaultBgResource(R.drawable.transparent_bg);
        this.nAO = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nCn = (TextView) this.mRootView.findViewById(R.id.txt_default);
        this.nDf = (TextView) this.mRootView.findViewById(R.id.view_card_name);
        this.nDg = this.mRootView.findViewById(R.id.black_stroke);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lit.getLayoutParams();
        layoutParams.height = this.eSJ;
        layoutParams.width = this.eSI;
        this.lit.setLayoutParams(layoutParams);
        this.nDg.setLayoutParams(layoutParams);
        this.lit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonalCardItemView.this.nDi != null) {
                    PersonalCardItemView.this.nDi.a(PersonalCardItemView.this.nDh);
                }
            }
        });
    }

    public void b(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nDh = aVar;
            if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nAi) {
                this.lit.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ao.setBackgroundColor(this.lit, R.color.CAM_X0204);
                ao.setImageResource(this.lit, R.drawable.icon_bubble_choose_no);
                this.nCn.setVisibility(0);
                this.nBD.setVisibility(8);
                this.liu.setVisibility(8);
            } else {
                this.nCn.setVisibility(8);
                this.nBD.setVisibility(0);
                this.liu.setVisibility(0);
                this.lit.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.lit.setImageBitmap(null);
                this.lit.setDefaultResource(R.drawable.img_default_100);
                this.lit.startLoad(aVar.dSv(), 10, false);
            }
            if (aVar.dSy() == 1) {
                this.nAO.setVisibility(0);
                ao.setImageResource(this.nAO, R.drawable.icon_choose_photo);
            } else {
                this.nAO.setVisibility(8);
            }
            this.liu.startLoad(aVar.dSw(), 10, false);
            this.nBD.startLoad(aVar.dSx(), 10, false);
            this.nDf.setText(aVar.getTitle());
            setVisibility(0);
        }
    }

    public a getCardViewController() {
        return this.nDi;
    }

    public void setCardViewController(a aVar) {
        this.nDi = aVar;
    }
}
