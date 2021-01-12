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
    private TbImageView nwY;
    private ImageView nwj;
    private TextView nxI;
    private TextView nyA;
    private View nyB;
    private com.baidu.tieba.themeCenter.a nyC;
    private a nyD;

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
        this.nwY = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nwY.setDefaultResource(R.drawable.transparent_bg);
        this.nwY.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwj = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nxI = (TextView) this.mRootView.findViewById(R.id.txt_default);
        this.nyA = (TextView) this.mRootView.findViewById(R.id.view_card_name);
        this.nyB = this.mRootView.findViewById(R.id.black_stroke);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ldN.getLayoutParams();
        layoutParams.height = this.eNY;
        layoutParams.width = this.eNX;
        this.ldN.setLayoutParams(layoutParams);
        this.nyB.setLayoutParams(layoutParams);
        this.ldN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonalCardItemView.this.nyD != null) {
                    PersonalCardItemView.this.nyD.a(PersonalCardItemView.this.nyC);
                }
            }
        });
    }

    public void b(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nyC = aVar;
            if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nvD) {
                this.ldN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ao.setBackgroundColor(this.ldN, R.color.CAM_X0204);
                ao.setImageResource(this.ldN, R.drawable.icon_bubble_choose_no);
                this.nxI.setVisibility(0);
                this.nwY.setVisibility(8);
                this.ldO.setVisibility(8);
            } else {
                this.nxI.setVisibility(8);
                this.nwY.setVisibility(0);
                this.ldO.setVisibility(0);
                this.ldN.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ldN.setImageBitmap(null);
                this.ldN.setDefaultResource(R.drawable.img_default_100);
                this.ldN.startLoad(aVar.dOD(), 10, false);
            }
            if (aVar.dOG() == 1) {
                this.nwj.setVisibility(0);
                ao.setImageResource(this.nwj, R.drawable.icon_choose_photo);
            } else {
                this.nwj.setVisibility(8);
            }
            this.ldO.startLoad(aVar.dOE(), 10, false);
            this.nwY.startLoad(aVar.dOF(), 10, false);
            this.nyA.setText(aVar.getTitle());
            setVisibility(0);
        }
    }

    public a getCardViewController() {
        return this.nyD;
    }

    public void setCardViewController(a aVar) {
        this.nyD = aVar;
    }
}
