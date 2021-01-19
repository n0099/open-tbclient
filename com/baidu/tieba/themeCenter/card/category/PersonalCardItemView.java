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
/* loaded from: classes8.dex */
public class PersonalCardItemView extends LinearLayout {
    private int eNX;
    private int eNY;
    private TbImageView ldN;
    private TbImageView ldO;
    private Context mContext;
    private View mRootView;
    private TbImageView nwZ;
    private ImageView nwk;
    private TextView nxJ;
    private TextView nyB;
    private View nyC;
    private com.baidu.tieba.themeCenter.a nyD;
    private a nyE;

    /* loaded from: classes8.dex */
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
        this.eNX = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eNY = (int) (this.eNX * 0.57d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.personal_card_item_layout, this);
        this.ldN = (TbImageView) this.mRootView.findViewById(R.id.image_bg);
        this.ldO = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.ldO.setDefaultResource(R.drawable.transparent_bg);
        this.ldO.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwZ = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nwZ.setDefaultResource(R.drawable.transparent_bg);
        this.nwZ.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwk = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nxJ = (TextView) this.mRootView.findViewById(R.id.txt_default);
        this.nyB = (TextView) this.mRootView.findViewById(R.id.view_card_name);
        this.nyC = this.mRootView.findViewById(R.id.black_stroke);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ldN.getLayoutParams();
        layoutParams.height = this.eNY;
        layoutParams.width = this.eNX;
        this.ldN.setLayoutParams(layoutParams);
        this.nyC.setLayoutParams(layoutParams);
        this.ldN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonalCardItemView.this.nyE != null) {
                    PersonalCardItemView.this.nyE.a(PersonalCardItemView.this.nyD);
                }
            }
        });
    }

    public void b(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nyD = aVar;
            if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nvE) {
                this.ldN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ao.setBackgroundColor(this.ldN, R.color.CAM_X0204);
                ao.setImageResource(this.ldN, R.drawable.icon_bubble_choose_no);
                this.nxJ.setVisibility(0);
                this.nwZ.setVisibility(8);
                this.ldO.setVisibility(8);
            } else {
                this.nxJ.setVisibility(8);
                this.nwZ.setVisibility(0);
                this.ldO.setVisibility(0);
                this.ldN.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ldN.setImageBitmap(null);
                this.ldN.setDefaultResource(R.drawable.img_default_100);
                this.ldN.startLoad(aVar.dOD(), 10, false);
            }
            if (aVar.dOG() == 1) {
                this.nwk.setVisibility(0);
                ao.setImageResource(this.nwk, R.drawable.icon_choose_photo);
            } else {
                this.nwk.setVisibility(8);
            }
            this.ldO.startLoad(aVar.dOE(), 10, false);
            this.nwZ.startLoad(aVar.dOF(), 10, false);
            this.nyB.setText(aVar.getTitle());
            setVisibility(0);
        }
    }

    public a getCardViewController() {
        return this.nyE;
    }

    public void setCardViewController(a aVar) {
        this.nyE = aVar;
    }
}
