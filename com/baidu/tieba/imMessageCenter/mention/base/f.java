package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f {
    private ImageView fBS;
    private TextView kem;
    private TBSpecificationBtn ken;
    private a keo;
    private com.baidu.adp.base.e mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == f.this.ken.getId()) {
                com.baidu.tbadk.coreExtra.c.a.f(f.this.mContext);
                TiebaStatic.log(new aq("c13705").aj("obj_type", 1));
            } else if (view.getId() == f.this.fBS.getId()) {
                com.baidu.tbadk.core.sharedPref.b.blO().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (f.this.keo != null) {
                    f.this.keo.onClose();
                }
                TiebaStatic.log(new aq("c13705").aj("obj_type", 2));
            }
        }
    };
    private View mView;

    /* loaded from: classes22.dex */
    public interface a {
        void onClose();
    }

    public f(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.fBS = (ImageView) this.mView.findViewById(R.id.img_close);
        this.fBS.setOnClickListener(this.mOnClickListener);
        this.kem = (TextView) this.mView.findViewById(R.id.open_desc);
        this.ken = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.ken.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        this.ken.setText(eVar.getString(R.string.go_to_open));
        this.ken.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mView, R.color.cp_bg_line_g);
        SvgManager.bmU().a(this.fBS, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.kem, R.color.cp_cont_j);
    }

    public void a(a aVar) {
        this.keo = aVar;
    }
}
