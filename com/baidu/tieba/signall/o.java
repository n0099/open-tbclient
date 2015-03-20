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
    private c cdH;
    private boolean cdT;
    private SignAllForumActivity cdY;
    private ArrayList<e> aix = new ArrayList<>();
    private HashMap<String, ag> cdZ = new HashMap<>();
    private boolean aGI = true;

    public o(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.cdY = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.cdH = cVar;
            this.aix = cVar.aim();
            if (this.aix.size() == 0) {
                this.aGI = false;
            } else {
                this.aGI = true;
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
        if (this.aGI) {
            return this.aix.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aix.size() > i) {
            return this.aix.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View ic(int i) {
        if (i == 0) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.cdY.getPageContext().getPageActivity(), com.baidu.tieba.w.signallforum_item, null);
            r rVar = new r(this);
            rVar.cef = (BarImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_avatar);
            rVar.cef.setIsRound(false);
            rVar.cef.setGifIconSupport(false);
            rVar.ceh = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_name);
            rVar.cei = (ImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level);
            rVar.cej = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_exp);
            rVar.cek = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_res_container);
            rVar.cel = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_days);
            rVar.cem = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_container);
            rVar.cen = (ImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_icon);
            rVar.ceo = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_progress);
            rVar.cep = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_text);
            rVar.ceq = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_error);
            rVar.ceg = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level_container);
            rVar.cer = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_increaseexp);
            inflate.setTag(rVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.hH().inflate(this.cdY.getPageContext().getPageActivity(), com.baidu.tieba.w.signallforum_header, null);
        q qVar = new q(this);
        qVar.ced = (TextView) inflate2.findViewById(com.baidu.tieba.v.signallforum_head_title);
        qVar.cee = (TextView) inflate2.findViewById(com.baidu.tieba.v.signallforum_head_res);
        inflate2.setTag(qVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.cdY.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cdY.getLayoutMode().h(view);
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
            rVar.ceh.setText(str);
            ba.c(rVar.cei, com.baidu.tbadk.core.util.c.bR(eVar.aiz()));
            rVar.cej.setText(String.valueOf(eVar.aiA()) + "/" + eVar.aiB());
            rVar.cer.clearAnimation();
            if (eVar.aiC()) {
                rVar.ceg.setVisibility(0);
                rVar.ceq.setVisibility(8);
                rVar.cel.setVisibility(0);
                rVar.cem.setVisibility(8);
                rVar.cel.setText(String.format(this.cdY.getPageContext().getString(com.baidu.tieba.y.signallforum_days), Integer.valueOf(eVar.aiy())));
                if (eVar.aiG()) {
                    rVar.cej.setText(this.cdY.getPageContext().getString(com.baidu.tieba.y.signallforum_uplevel));
                    rVar.cer.setVisibility(8);
                } else {
                    rVar.cej.setText(String.valueOf(eVar.aiA()) + "/" + eVar.aiB());
                    rVar.cer.setVisibility(0);
                }
                int aiF = eVar.aiF();
                if (aiF > 0) {
                    rVar.cer.setVisibility(0);
                    rVar.cer.setText("+" + aiF);
                } else {
                    rVar.cer.setVisibility(8);
                }
            } else if (eVar.aiD()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    rVar.ceg.setVisibility(8);
                    rVar.ceq.setVisibility(0);
                    rVar.cer.setVisibility(8);
                    rVar.ceq.setText(errorMsg);
                } else {
                    rVar.ceg.setVisibility(0);
                    rVar.ceq.setVisibility(8);
                    rVar.cer.setVisibility(8);
                }
                rVar.cel.setVisibility(8);
                rVar.cem.setVisibility(0);
                if (eVar.aiE()) {
                    rVar.cen.setVisibility(4);
                    rVar.ceo.setVisibility(0);
                    rVar.cep.setText(com.baidu.tieba.y.signallforum_resigning);
                } else {
                    rVar.cen.setVisibility(0);
                    rVar.ceo.setVisibility(4);
                    rVar.cep.setText(com.baidu.tieba.y.signallforum_resign);
                }
                rVar.cem.setOnClickListener(new p(this, eVar, rVar));
            } else {
                rVar.cel.setVisibility(8);
                rVar.cem.setVisibility(8);
                rVar.cer.setVisibility(8);
                rVar.ceg.setVisibility(0);
                rVar.ceq.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            rVar.cef.setTag(avatar);
            rVar.cef.c(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        q qVar;
        if (!this.aGI) {
            return It();
        }
        int itemViewType = getItemViewType(i);
        View ic = view == null ? ic(itemViewType) : view;
        if (itemViewType == 1) {
            if (ic.getTag() != null && (ic.getTag() instanceof q)) {
                view2 = ic;
                qVar = (q) ic.getTag();
            } else {
                View ic2 = ic(itemViewType);
                view2 = ic2;
                qVar = (q) ic2.getTag();
            }
            this.cdY.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.cdY.getLayoutMode().h(view2.findViewById(com.baidu.tieba.v.sign_all_forum_tip));
            qVar.ced.setText(((b) getItem(i)).getTitle());
            q(qVar.cee, i);
            return view2;
        }
        if (ic.getTag() == null || !(ic.getTag() instanceof r)) {
            ic = ic(itemViewType);
        }
        a(ic, viewGroup, i);
        return ic;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.cdH == null ? 7 : this.cdH.getLevel();
        if (this.aix == null || this.aix.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<e> it = this.aix.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.aiz() >= level) {
                        if (next.aiC()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aiC()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.cdY.getPageContext().getString(com.baidu.tieba.y.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.cdY.getPageContext().getString(com.baidu.tieba.y.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View It() {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.cdY.getPageContext().getPageActivity(), com.baidu.tieba.w.sign_all_forum_nodata_item, null);
        com.baidu.tbadk.core.view.s a = NoDataViewFactory.a(this.cdY.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(com.baidu.tieba.v.sign_all_forum_no_data_view), com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.SINGALL, 0), com.baidu.tbadk.core.view.w.r(com.baidu.tieba.y.sign_all_forum_nodata_tip, com.baidu.tieba.y.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cdY.getLayoutMode().X(skinType == 1);
        this.cdY.getLayoutMode().h(inflate);
        a.onChangeSkinType(this.cdY.getPageContext(), skinType);
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
            this.cdZ.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ah
    public void aU(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.n.showToast(this.cdY.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.cdZ.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.aix.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.aix.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.ez(z);
                eVar.eA(!z);
                eVar.eB(false);
                if (z) {
                    eVar.hZ(signData.getCountSignNum());
                    eVar.ib(signData.getBonusPoint());
                    eVar.hY(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> aip = this.cdH.aip();
                    if (aip.contains(eVar)) {
                        aip.remove(eVar);
                        this.cdH.aio().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.cdT) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void aiJ() {
        this.cdT = true;
        synchronized (this) {
            for (Map.Entry<String, ag> entry : this.cdZ.entrySet()) {
                entry.getValue().aja();
            }
            this.cdZ.clear();
        }
    }
}
