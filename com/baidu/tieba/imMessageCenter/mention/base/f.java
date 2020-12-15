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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f {
    private ImageView fXX;
    private TextView kKM;
    private TBSpecificationBtn kKN;
    private a kKO;
    private com.baidu.adp.base.e mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == f.this.kKN.getId()) {
                com.baidu.tbadk.coreExtra.c.a.f(f.this.mContext);
                TiebaStatic.log(new ar("c13705").al("obj_type", 1));
            } else if (view.getId() == f.this.fXX.getId()) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (f.this.kKO != null) {
                    f.this.kKO.onClose();
                }
                TiebaStatic.log(new ar("c13705").al("obj_type", 2));
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
        this.fXX = (ImageView) this.mView.findViewById(R.id.img_close);
        this.fXX.setOnClickListener(this.mOnClickListener);
        this.kKM = (TextView) this.mView.findViewById(R.id.open_desc);
        this.kKN = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.kKN.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        this.kKN.setText(eVar.getString(R.string.go_to_open));
        this.kKN.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mView, R.color.CAM_X0206);
        SvgManager.btW().a(this.fXX, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.kKM, R.color.CAM_X0107);
    }

    public void a(a aVar) {
        this.kKO = aVar;
    }
}
