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
/* loaded from: classes8.dex */
public class PersonalCardItemView extends LinearLayout {
    private int eRK;
    private int eRL;
    private TbImageView loj;
    private TbImageView lok;
    private Context mContext;
    private View mRootView;
    private ImageView nIA;
    private TextView nJZ;
    private TbImageView nJp;
    private TextView nKR;
    private View nKS;
    private com.baidu.tieba.themeCenter.a nKT;
    private a nKU;

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
        this.eRK = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eRL = (int) (this.eRK * 0.57d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.personal_card_item_layout, this);
        this.loj = (TbImageView) this.mRootView.findViewById(R.id.image_bg);
        this.lok = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lok.setDefaultResource(R.drawable.transparent_bg);
        this.lok.setDefaultBgResource(R.drawable.transparent_bg);
        this.nJp = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nJp.setDefaultResource(R.drawable.transparent_bg);
        this.nJp.setDefaultBgResource(R.drawable.transparent_bg);
        this.nIA = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nJZ = (TextView) this.mRootView.findViewById(R.id.txt_default);
        this.nKR = (TextView) this.mRootView.findViewById(R.id.view_card_name);
        this.nKS = this.mRootView.findViewById(R.id.black_stroke);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.loj.getLayoutParams();
        layoutParams.height = this.eRL;
        layoutParams.width = this.eRK;
        this.loj.setLayoutParams(layoutParams);
        this.nKS.setLayoutParams(layoutParams);
        this.loj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonalCardItemView.this.nKU != null) {
                    PersonalCardItemView.this.nKU.a(PersonalCardItemView.this.nKT);
                }
            }
        });
    }

    public void b(com.baidu.tieba.themeCenter.a aVar) {
        if (aVar != null) {
            this.nKT = aVar;
            if (aVar.getCardId() == com.baidu.tieba.themeCenter.a.nHU) {
                this.loj.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ap.setBackgroundColor(this.loj, R.color.CAM_X0204);
                ap.setImageResource(this.loj, R.drawable.icon_bubble_choose_no);
                this.nJZ.setVisibility(0);
                this.nJp.setVisibility(8);
                this.lok.setVisibility(8);
            } else {
                this.nJZ.setVisibility(8);
                this.nJp.setVisibility(0);
                this.lok.setVisibility(0);
                this.loj.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.loj.setImageBitmap(null);
                this.loj.setDefaultResource(R.drawable.img_default_100);
                this.loj.startLoad(aVar.dRf(), 10, false);
            }
            if (aVar.dRi() == 1) {
                this.nIA.setVisibility(0);
                ap.setImageResource(this.nIA, R.drawable.icon_choose_photo);
            } else {
                this.nIA.setVisibility(8);
            }
            this.lok.startLoad(aVar.dRg(), 10, false);
            this.nJp.startLoad(aVar.dRh(), 10, false);
            this.nKR.setText(aVar.getTitle());
            setVisibility(0);
        }
    }

    public a getCardViewController() {
        return this.nKU;
    }

    public void setCardViewController(a aVar) {
        this.nKU = aVar;
    }
}
