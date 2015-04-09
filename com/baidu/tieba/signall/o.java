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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends BaseAdapter implements AbsListView.OnScrollListener, ah {
    private c cdW;
    private boolean cei;
    private SignAllForumActivity cen;
    private ArrayList<e> aiF = new ArrayList<>();
    private HashMap<String, ag> ceo = new HashMap<>();
    private boolean aGQ = true;

    public o(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.cen = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.cdW = cVar;
            this.aiF = cVar.aiB();
            if (this.aiF.size() == 0) {
                this.aGQ = false;
            } else {
                this.aGQ = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aGQ) {
            return this.aiF.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aiF.size() > i) {
            return this.aiF.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View ig(int i) {
        if (i == 0) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.cen.getPageContext().getPageActivity(), com.baidu.tieba.w.signallforum_item, null);
            r rVar = new r(this);
            rVar.ceu = (BarImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_avatar);
            rVar.ceu.setIsRound(false);
            rVar.ceu.setGifIconSupport(false);
            rVar.cew = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_name);
            rVar.cex = (ImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level);
            rVar.cey = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_exp);
            rVar.cez = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_res_container);
            rVar.ceA = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_days);
            rVar.ceB = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_container);
            rVar.ceC = (ImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_icon);
            rVar.ceD = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_progress);
            rVar.ceE = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_text);
            rVar.ceF = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_error);
            rVar.cev = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level_container);
            rVar.ceG = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_increaseexp);
            inflate.setTag(rVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.hH().inflate(this.cen.getPageContext().getPageActivity(), com.baidu.tieba.w.signallforum_header, null);
        q qVar = new q(this);
        qVar.ces = (TextView) inflate2.findViewById(com.baidu.tieba.v.signallforum_head_title);
        qVar.cet = (TextView) inflate2.findViewById(com.baidu.tieba.v.signallforum_head_res);
        inflate2.setTag(qVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.cen.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cen.getLayoutMode().h(view);
        r rVar = (r) view.getTag();
        e eVar = (e) getItem(i);
        if (eVar != null) {
            String forumName = eVar.getForumName();
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
            rVar.cew.setText(str);
            ba.c(rVar.cex, com.baidu.tbadk.core.util.c.bR(eVar.aiO()));
            rVar.cey.setText(String.valueOf(eVar.aiP()) + "/" + eVar.aiQ());
            rVar.ceG.clearAnimation();
            if (eVar.aiR()) {
                rVar.cev.setVisibility(0);
                rVar.ceF.setVisibility(8);
                rVar.ceA.setVisibility(0);
                rVar.ceB.setVisibility(8);
                rVar.ceA.setText(String.format(this.cen.getPageContext().getString(com.baidu.tieba.y.signallforum_days), Integer.valueOf(eVar.aiN())));
                if (eVar.aiV()) {
                    rVar.cey.setText(this.cen.getPageContext().getString(com.baidu.tieba.y.signallforum_uplevel));
                    rVar.ceG.setVisibility(8);
                } else {
                    rVar.cey.setText(String.valueOf(eVar.aiP()) + "/" + eVar.aiQ());
                    rVar.ceG.setVisibility(0);
                }
                int aiU = eVar.aiU();
                if (aiU > 0) {
                    rVar.ceG.setVisibility(0);
                    rVar.ceG.setText("+" + aiU);
                } else {
                    rVar.ceG.setVisibility(8);
                }
            } else if (eVar.aiS()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    rVar.cev.setVisibility(8);
                    rVar.ceF.setVisibility(0);
                    rVar.ceG.setVisibility(8);
                    rVar.ceF.setText(errorMsg);
                } else {
                    rVar.cev.setVisibility(0);
                    rVar.ceF.setVisibility(8);
                    rVar.ceG.setVisibility(8);
                }
                rVar.ceA.setVisibility(8);
                rVar.ceB.setVisibility(0);
                if (eVar.aiT()) {
                    rVar.ceC.setVisibility(4);
                    rVar.ceD.setVisibility(0);
                    rVar.ceE.setText(com.baidu.tieba.y.signallforum_resigning);
                } else {
                    rVar.ceC.setVisibility(0);
                    rVar.ceD.setVisibility(4);
                    rVar.ceE.setText(com.baidu.tieba.y.signallforum_resign);
                }
                rVar.ceB.setOnClickListener(new p(this, eVar, rVar));
            } else {
                rVar.ceA.setVisibility(8);
                rVar.ceB.setVisibility(8);
                rVar.ceG.setVisibility(8);
                rVar.cev.setVisibility(0);
                rVar.ceF.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            rVar.ceu.setTag(avatar);
            rVar.ceu.c(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.aGQ) {
            return Iz();
        }
        int itemViewType = getItemViewType(i);
        View ig = view == null ? ig(itemViewType) : view;
        if (itemViewType == 1) {
            if (ig.getTag() != null && (ig.getTag() instanceof q)) {
                view2 = ig;
                qVar = (q) ig.getTag();
            } else {
                View ig2 = ig(itemViewType);
                view2 = ig2;
                qVar = (q) ig2.getTag();
            }
            this.cen.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.cen.getLayoutMode().h(view2.findViewById(com.baidu.tieba.v.sign_all_forum_tip));
            qVar.ces.setText(((b) getItem(i)).getTitle());
            q(qVar.cet, i);
            return view2;
        }
        if (ig.getTag() == null || !(ig.getTag() instanceof r)) {
            ig = ig(itemViewType);
        }
        a(ig, viewGroup, i);
        return ig;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.cdW == null ? 7 : this.cdW.getLevel();
        if (this.aiF == null || this.aiF.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<e> it = this.aiF.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.aiO() >= level) {
                        if (next.aiR()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aiR()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.cen.getPageContext().getString(com.baidu.tieba.y.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.cen.getPageContext().getString(com.baidu.tieba.y.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View Iz() {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.cen.getPageContext().getPageActivity(), com.baidu.tieba.w.sign_all_forum_nodata_item, null);
        com.baidu.tbadk.core.view.s a = NoDataViewFactory.a(this.cen.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(com.baidu.tieba.v.sign_all_forum_no_data_view), com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.SINGALL, 0), com.baidu.tbadk.core.view.w.r(com.baidu.tieba.y.sign_all_forum_nodata_tip, com.baidu.tieba.y.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cen.getLayoutMode().X(skinType == 1);
        this.cen.getLayoutMode().h(inflate);
        a.onChangeSkinType(this.cen.getPageContext(), skinType);
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

    @Override // com.baidu.tieba.signall.ah
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.ceo.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ah
    public void aU(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.n.showToast(this.cen.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.ceo.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.aiF.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.aiF.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.ex(z);
                eVar.ey(!z);
                eVar.ez(false);
                if (z) {
                    eVar.ic(signData.getCountSignNum());
                    eVar.ie(signData.getBonusPoint());
                    eVar.ib(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> aiE = this.cdW.aiE();
                    if (aiE.contains(eVar)) {
                        aiE.remove(eVar);
                        this.cdW.aiD().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.cei) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void aiY() {
        this.cei = true;
        synchronized (this) {
            for (Map.Entry<String, ag> entry : this.ceo.entrySet()) {
                entry.getValue().ajp();
            }
            this.ceo.clear();
        }
    }
}
