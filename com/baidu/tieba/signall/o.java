package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends BaseAdapter implements AbsListView.OnScrollListener, ag {
    private boolean aHD;
    private b bPd;
    private SignAllForumActivity bPt;
    private ArrayList<d> XL = new ArrayList<>();
    private HashMap<String, af> bPu = new HashMap<>();
    private boolean axy = true;

    public o(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.bPt = signAllForumActivity;
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.bPd = bVar;
            this.XL = bVar.acV();
            if (this.XL.size() == 0) {
                this.axy = false;
            } else {
                this.axy = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof a ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.axy) {
            return this.XL.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.XL.size() > i) {
            return this.XL.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View hx(int i) {
        if (i == 0) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bPt.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_item, null);
            r rVar = new r(this);
            rVar.bPA = (BarImageView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_avatar);
            rVar.bPA.setIsRound(false);
            rVar.bPA.setGifIconSupport(false);
            rVar.bPA.setSupportNoImage(false);
            rVar.bPC = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_name);
            rVar.bPD = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_level);
            rVar.bPE = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_exp);
            rVar.bPF = (FrameLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_res_container);
            rVar.bPG = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_days);
            rVar.bPH = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_container);
            rVar.bPI = (ImageView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_icon);
            rVar.bPJ = (ProgressBar) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_progress);
            rVar.bPK = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_resign_text);
            rVar.bPL = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_error);
            rVar.bPB = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.signallforum_item_level_container);
            rVar.bPM = (TextView) inflate.findViewById(com.baidu.tieba.w.signallforum_item_increaseexp);
            inflate.setTag(rVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bPt.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_header, null);
        q qVar = new q(this);
        qVar.bPy = (TextView) inflate2.findViewById(com.baidu.tieba.w.signallforum_head_title);
        qVar.bPz = (TextView) inflate2.findViewById(com.baidu.tieba.w.signallforum_head_res);
        inflate2.setTag(qVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.bPt.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bPt.getLayoutMode().h(view);
        r rVar = (r) view.getTag();
        d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = String.valueOf(forumName.substring(0, i3)) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            rVar.bPC.setText(str);
            rVar.bPD.setText(new StringBuilder(String.valueOf(dVar.adi())).toString());
            ax.i((View) rVar.bPD, com.baidu.tbadk.core.util.d.bK(dVar.adi()));
            rVar.bPE.setText(String.valueOf(dVar.adj()) + "/" + dVar.adk());
            rVar.bPM.clearAnimation();
            if (dVar.adl()) {
                rVar.bPB.setVisibility(0);
                rVar.bPL.setVisibility(8);
                rVar.bPG.setVisibility(0);
                rVar.bPH.setVisibility(8);
                rVar.bPG.setText(String.format(this.bPt.getPageContext().getString(com.baidu.tieba.z.signallforum_days), Integer.valueOf(dVar.adh())));
                if (dVar.adp()) {
                    rVar.bPE.setText(this.bPt.getPageContext().getString(com.baidu.tieba.z.signallforum_uplevel));
                    rVar.bPM.setVisibility(8);
                } else {
                    rVar.bPE.setText(String.valueOf(dVar.adj()) + "/" + dVar.adk());
                    rVar.bPM.setVisibility(0);
                }
                int ado = dVar.ado();
                if (ado > 0) {
                    rVar.bPM.setVisibility(0);
                    rVar.bPM.setText("+" + ado);
                } else {
                    rVar.bPM.setVisibility(8);
                }
            } else if (dVar.adm()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    rVar.bPB.setVisibility(8);
                    rVar.bPL.setVisibility(0);
                    rVar.bPM.setVisibility(8);
                    rVar.bPL.setText(errorMsg);
                } else {
                    rVar.bPB.setVisibility(0);
                    rVar.bPL.setVisibility(8);
                    rVar.bPM.setVisibility(8);
                }
                rVar.bPG.setVisibility(8);
                rVar.bPH.setVisibility(0);
                if (dVar.adn()) {
                    rVar.bPI.setVisibility(4);
                    rVar.bPJ.setVisibility(0);
                    rVar.bPK.setText(com.baidu.tieba.z.signallforum_resigning);
                } else {
                    rVar.bPI.setVisibility(0);
                    rVar.bPJ.setVisibility(4);
                    rVar.bPK.setText(com.baidu.tieba.z.signallforum_resign);
                }
                rVar.bPH.setOnClickListener(new p(this, dVar, rVar));
            } else {
                rVar.bPG.setVisibility(8);
                rVar.bPH.setVisibility(8);
                rVar.bPM.setVisibility(8);
                rVar.bPB.setVisibility(0);
                rVar.bPL.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            rVar.bPA.setTag(avatar);
            rVar.bPA.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.axy) {
            return DU();
        }
        int itemViewType = getItemViewType(i);
        View hx = view == null ? hx(itemViewType) : view;
        if (itemViewType == 1) {
            if (hx.getTag() != null && (hx.getTag() instanceof q)) {
                view2 = hx;
                qVar = (q) hx.getTag();
            } else {
                View hx2 = hx(itemViewType);
                view2 = hx2;
                qVar = (q) hx2.getTag();
            }
            this.bPt.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
            this.bPt.getLayoutMode().h(view2.findViewById(com.baidu.tieba.w.sign_all_forum_tip));
            qVar.bPy.setText(((a) getItem(i)).getTitle());
            q(qVar.bPz, i);
            return view2;
        }
        if (hx.getTag() == null || !(hx.getTag() instanceof r)) {
            hx = hx(itemViewType);
        }
        a(hx, viewGroup, i);
        return hx;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.bPd == null ? 7 : this.bPd.getLevel();
        if (this.XL == null || this.XL.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.XL.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.adi() >= level) {
                        if (next.adl()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.adl()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.bPt.getPageContext().getString(com.baidu.tieba.z.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.bPt.getPageContext().getString(com.baidu.tieba.z.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View DU() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bPt.getPageContext().getPageActivity(), com.baidu.tieba.x.sign_all_forum_nodata_item, null);
        com.baidu.tbadk.core.view.x a = NoDataViewFactory.a(this.bPt.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(com.baidu.tieba.w.sign_all_forum_no_data_view), com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.SINGALL, 0), com.baidu.tbadk.core.view.ab.t(com.baidu.tieba.z.sign_all_forum_nodata_tip, com.baidu.tieba.z.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.bPt.getLayoutMode().ab(skinType == 1);
        this.bPt.getLayoutMode().h(inflate);
        a.onChangeSkinType(this.bPt.getPageContext(), skinType);
        a.setVisibility(0);
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.signall.ag
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.bPu.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ag
    public void aM(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.l.showToast(this.bPt.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.bPu.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.XL.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.XL.get(i);
            if (new StringBuilder(String.valueOf(dVar.getForumId())).toString().equals(str)) {
                dVar.ek(z);
                dVar.el(!z);
                dVar.em(false);
                if (z) {
                    dVar.hu(signData.getCountSignNum());
                    dVar.hw(signData.getBonusPoint());
                    dVar.ht(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<d> acY = this.bPd.acY();
                    if (acY.contains(dVar)) {
                        acY.remove(dVar);
                        this.bPd.acX().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.aHD) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void adt() {
        this.aHD = true;
        synchronized (this) {
            for (Map.Entry<String, af> entry : this.bPu.entrySet()) {
                entry.getValue().adK();
            }
            this.bPu.clear();
        }
    }
}
