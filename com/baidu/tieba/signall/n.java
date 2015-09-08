package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends BaseAdapter implements AbsListView.OnScrollListener, ab.a {
    private c cIN;
    private boolean cIZ;
    private SignAllForumActivity cJe;
    private ArrayList<e> mDatas = new ArrayList<>();
    private HashMap<String, ab> cJf = new HashMap<>();
    private boolean aQO = true;

    public n(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.cJe = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.cIN = cVar;
            this.mDatas = cVar.aqW();
            if (this.mDatas.size() == 0) {
                this.aQO = false;
            } else {
                this.aQO = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof com.baidu.tieba.signall.b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQO) {
            return this.mDatas.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mDatas.size() > i) {
            return this.mDatas.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View kg(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.cJe.getPageContext().getPageActivity()).inflate(i.g.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.cJl = (BarImageView) inflate.findViewById(i.f.signallforum_item_avatar);
            bVar.cJl.setIsRound(false);
            bVar.cJl.setGifIconSupport(false);
            bVar.cJn = (TextView) inflate.findViewById(i.f.signallforum_item_name);
            bVar.cJo = (ImageView) inflate.findViewById(i.f.signallforum_item_level);
            bVar.cJp = (TextView) inflate.findViewById(i.f.signallforum_item_exp);
            bVar.cJq = (FrameLayout) inflate.findViewById(i.f.signallforum_item_res_container);
            bVar.cJr = (TextView) inflate.findViewById(i.f.signallforum_item_days);
            bVar.cJs = (RelativeLayout) inflate.findViewById(i.f.signallforum_item_resign_container);
            bVar.cJt = (ImageView) inflate.findViewById(i.f.signallforum_item_resign_icon);
            bVar.cJu = (ProgressBar) inflate.findViewById(i.f.signallforum_item_resign_progress);
            bVar.cJv = (TextView) inflate.findViewById(i.f.signallforum_item_resign_text);
            bVar.cJw = (TextView) inflate.findViewById(i.f.signallforum_item_error);
            bVar.cJm = (LinearLayout) inflate.findViewById(i.f.signallforum_item_level_container);
            bVar.cJx = (TextView) inflate.findViewById(i.f.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.cJe.getPageContext().getPageActivity()).inflate(i.g.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.cJj = (TextView) inflate2.findViewById(i.f.signallforum_head_title);
        aVar.cJk = (TextView) inflate2.findViewById(i.f.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.cJe.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cJe.getLayoutMode().k(view);
        b bVar = (b) view.getTag();
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
            bVar.cJn.setText(str);
            al.c(bVar.cJo, com.baidu.tbadk.core.util.c.cg(eVar.arj()));
            bVar.cJp.setText(String.valueOf(eVar.ark()) + "/" + eVar.arl());
            bVar.cJx.clearAnimation();
            if (eVar.arm()) {
                bVar.cJm.setVisibility(0);
                bVar.cJw.setVisibility(8);
                bVar.cJr.setVisibility(0);
                bVar.cJs.setVisibility(8);
                bVar.cJr.setText(String.format(this.cJe.getPageContext().getString(i.h.signallforum_days), Integer.valueOf(eVar.ari())));
                if (eVar.arq()) {
                    bVar.cJp.setText(this.cJe.getPageContext().getString(i.h.signallforum_uplevel));
                    bVar.cJx.setVisibility(8);
                } else {
                    bVar.cJp.setText(String.valueOf(eVar.ark()) + "/" + eVar.arl());
                    bVar.cJx.setVisibility(0);
                }
                int arp = eVar.arp();
                if (arp > 0) {
                    bVar.cJx.setVisibility(0);
                    bVar.cJx.setText("+" + arp);
                } else {
                    bVar.cJx.setVisibility(8);
                }
            } else if (eVar.arn()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.cJm.setVisibility(8);
                    bVar.cJw.setVisibility(0);
                    bVar.cJx.setVisibility(8);
                    bVar.cJw.setText(errorMsg);
                } else {
                    bVar.cJm.setVisibility(0);
                    bVar.cJw.setVisibility(8);
                    bVar.cJx.setVisibility(8);
                }
                bVar.cJr.setVisibility(8);
                bVar.cJs.setVisibility(0);
                if (eVar.aro()) {
                    bVar.cJt.setVisibility(4);
                    bVar.cJu.setVisibility(0);
                    bVar.cJv.setText(i.h.signallforum_resigning);
                } else {
                    bVar.cJt.setVisibility(0);
                    bVar.cJu.setVisibility(4);
                    bVar.cJv.setText(i.h.signallforum_resign);
                }
                bVar.cJs.setOnClickListener(new o(this, eVar, bVar));
            } else {
                bVar.cJr.setVisibility(8);
                bVar.cJs.setVisibility(8);
                bVar.cJx.setVisibility(8);
                bVar.cJm.setVisibility(0);
                bVar.cJw.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.cJl.setTag(avatar);
            bVar.cJl.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.aQO) {
            return Kc();
        }
        int itemViewType = getItemViewType(i);
        View kg = view == null ? kg(itemViewType) : view;
        if (itemViewType == 1) {
            if (kg.getTag() != null && (kg.getTag() instanceof a)) {
                view2 = kg;
                aVar = (a) kg.getTag();
            } else {
                View kg2 = kg(itemViewType);
                view2 = kg2;
                aVar = (a) kg2.getTag();
            }
            this.cJe.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.cJe.getLayoutMode().k(view2.findViewById(i.f.sign_all_forum_tip));
            aVar.cJj.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            q(aVar.cJk, i);
            return view2;
        }
        if (kg.getTag() == null || !(kg.getTag() instanceof b)) {
            kg = kg(itemViewType);
        }
        a(kg, viewGroup, i);
        return kg;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.cIN == null ? 7 : this.cIN.getLevel();
        if (this.mDatas == null || this.mDatas.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<e> it = this.mDatas.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.arj() >= level) {
                        if (next.arm()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.arm()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.cJe.getPageContext().getString(i.h.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.cJe.getPageContext().getString(i.h.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View Kc() {
        View inflate = LayoutInflater.from(this.cJe.getPageContext().getPageActivity()).inflate(i.g.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.u a2 = NoDataViewFactory.a(this.cJe.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(i.f.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(i.h.sign_all_forum_nodata_tip, i.h.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cJe.getLayoutMode().ad(skinType == 1);
        this.cJe.getLayoutMode().k(inflate);
        a2.onChangeSkinType(this.cJe.getPageContext(), skinType);
        a2.setVisibility(0);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {
        public BarImageView cJl;
        public LinearLayout cJm;
        public TextView cJn;
        public ImageView cJo;
        public TextView cJp;
        public FrameLayout cJq;
        public TextView cJr;
        public RelativeLayout cJs;
        public ImageView cJt;
        public ProgressBar cJu;
        public TextView cJv;
        public TextView cJw;
        public TextView cJx;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView cJj;
        public TextView cJk;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.cJf.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void bd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.cJe.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.cJf.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.mDatas.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.mDatas.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.fV(z);
                eVar.fW(!z);
                eVar.fX(false);
                if (z) {
                    eVar.kd(signData.getCountSignNum());
                    eVar.kf(signData.getBonusPoint());
                    eVar.kc(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> aqZ = this.cIN.aqZ();
                    if (aqZ.contains(eVar)) {
                        aqZ.remove(eVar);
                        this.cIN.aqY().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.cIZ) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void art() {
        this.cIZ = true;
        synchronized (this) {
            for (Map.Entry<String, ab> entry : this.cJf.entrySet()) {
                entry.getValue().arK();
            }
            this.cJf.clear();
        }
    }
}
