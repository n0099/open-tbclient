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
import com.baidu.tbadk.core.util.an;
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
    private c cQh;
    private boolean cQt;
    private SignAllForumActivity cQy;
    private ArrayList<e> mDatas = new ArrayList<>();
    private HashMap<String, ab> cQz = new HashMap<>();
    private boolean aPV = true;

    public n(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.cQy = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.cQh = cVar;
            this.mDatas = cVar.atq();
            if (this.mDatas.size() == 0) {
                this.aPV = false;
            } else {
                this.aPV = true;
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
        if (this.aPV) {
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

    private View kH(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.cQy.getPageContext().getPageActivity()).inflate(i.g.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.cQF = (BarImageView) inflate.findViewById(i.f.signallforum_item_avatar);
            bVar.cQF.setIsRound(false);
            bVar.cQF.setGifIconSupport(false);
            bVar.cQH = (TextView) inflate.findViewById(i.f.signallforum_item_name);
            bVar.cQI = (ImageView) inflate.findViewById(i.f.signallforum_item_level);
            bVar.cQJ = (TextView) inflate.findViewById(i.f.signallforum_item_exp);
            bVar.cQK = (FrameLayout) inflate.findViewById(i.f.signallforum_item_res_container);
            bVar.cQL = (TextView) inflate.findViewById(i.f.signallforum_item_days);
            bVar.cQM = (RelativeLayout) inflate.findViewById(i.f.signallforum_item_resign_container);
            bVar.cQN = (ImageView) inflate.findViewById(i.f.signallforum_item_resign_icon);
            bVar.cQO = (ProgressBar) inflate.findViewById(i.f.signallforum_item_resign_progress);
            bVar.cQP = (TextView) inflate.findViewById(i.f.signallforum_item_resign_text);
            bVar.cQQ = (TextView) inflate.findViewById(i.f.signallforum_item_error);
            bVar.cQG = (LinearLayout) inflate.findViewById(i.f.signallforum_item_level_container);
            bVar.cQR = (TextView) inflate.findViewById(i.f.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.cQy.getPageContext().getPageActivity()).inflate(i.g.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.cQD = (TextView) inflate2.findViewById(i.f.signallforum_head_title);
        aVar.cQE = (TextView) inflate2.findViewById(i.f.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.cQy.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cQy.getLayoutMode().k(view);
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
            bVar.cQH.setText(str);
            an.c(bVar.cQI, com.baidu.tbadk.core.util.c.ci(eVar.atD()));
            bVar.cQJ.setText(String.valueOf(eVar.atE()) + "/" + eVar.atF());
            bVar.cQR.clearAnimation();
            if (eVar.atG()) {
                bVar.cQG.setVisibility(0);
                bVar.cQQ.setVisibility(8);
                bVar.cQL.setVisibility(0);
                bVar.cQM.setVisibility(8);
                bVar.cQL.setText(String.format(this.cQy.getPageContext().getString(i.h.signallforum_days), Integer.valueOf(eVar.atC())));
                if (eVar.atK()) {
                    bVar.cQJ.setText(this.cQy.getPageContext().getString(i.h.signallforum_uplevel));
                    bVar.cQR.setVisibility(8);
                } else {
                    bVar.cQJ.setText(String.valueOf(eVar.atE()) + "/" + eVar.atF());
                    bVar.cQR.setVisibility(0);
                }
                int atJ = eVar.atJ();
                if (atJ > 0) {
                    bVar.cQR.setVisibility(0);
                    bVar.cQR.setText("+" + atJ);
                } else {
                    bVar.cQR.setVisibility(8);
                }
            } else if (eVar.atH()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.cQG.setVisibility(8);
                    bVar.cQQ.setVisibility(0);
                    bVar.cQR.setVisibility(8);
                    bVar.cQQ.setText(errorMsg);
                } else {
                    bVar.cQG.setVisibility(0);
                    bVar.cQQ.setVisibility(8);
                    bVar.cQR.setVisibility(8);
                }
                bVar.cQL.setVisibility(8);
                bVar.cQM.setVisibility(0);
                if (eVar.atI()) {
                    bVar.cQN.setVisibility(4);
                    bVar.cQO.setVisibility(0);
                    bVar.cQP.setText(i.h.signallforum_resigning);
                } else {
                    bVar.cQN.setVisibility(0);
                    bVar.cQO.setVisibility(4);
                    bVar.cQP.setText(i.h.signallforum_resign);
                }
                bVar.cQM.setOnClickListener(new o(this, eVar, bVar));
            } else {
                bVar.cQL.setVisibility(8);
                bVar.cQM.setVisibility(8);
                bVar.cQR.setVisibility(8);
                bVar.cQG.setVisibility(0);
                bVar.cQQ.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.cQF.setTag(avatar);
            bVar.cQF.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.aPV) {
            return JX();
        }
        int itemViewType = getItemViewType(i);
        View kH = view == null ? kH(itemViewType) : view;
        if (itemViewType == 1) {
            if (kH.getTag() != null && (kH.getTag() instanceof a)) {
                view2 = kH;
                aVar = (a) kH.getTag();
            } else {
                View kH2 = kH(itemViewType);
                view2 = kH2;
                aVar = (a) kH2.getTag();
            }
            this.cQy.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.cQy.getLayoutMode().k(view2.findViewById(i.f.sign_all_forum_tip));
            aVar.cQD.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            q(aVar.cQE, i);
            return view2;
        }
        if (kH.getTag() == null || !(kH.getTag() instanceof b)) {
            kH = kH(itemViewType);
        }
        a(kH, viewGroup, i);
        return kH;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.cQh == null ? 7 : this.cQh.getLevel();
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
                    if (next.atD() >= level) {
                        if (next.atG()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.atG()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.cQy.getPageContext().getString(i.h.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.cQy.getPageContext().getString(i.h.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View JX() {
        View inflate = LayoutInflater.from(this.cQy.getPageContext().getPageActivity()).inflate(i.g.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.m a2 = NoDataViewFactory.a(this.cQy.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(i.f.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(i.h.sign_all_forum_nodata_tip, i.h.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cQy.getLayoutMode().ad(skinType == 1);
        this.cQy.getLayoutMode().k(inflate);
        a2.onChangeSkinType(this.cQy.getPageContext(), skinType);
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
        public BarImageView cQF;
        public LinearLayout cQG;
        public TextView cQH;
        public ImageView cQI;
        public TextView cQJ;
        public FrameLayout cQK;
        public TextView cQL;
        public RelativeLayout cQM;
        public ImageView cQN;
        public ProgressBar cQO;
        public TextView cQP;
        public TextView cQQ;
        public TextView cQR;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView cQD;
        public TextView cQE;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.cQz.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void bd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.cQy.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.cQz.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.mDatas.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.mDatas.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.gg(z);
                eVar.gh(!z);
                eVar.gi(false);
                if (z) {
                    eVar.kE(signData.getCountSignNum());
                    eVar.kG(signData.getBonusPoint());
                    eVar.kD(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> att = this.cQh.att();
                    if (att.contains(eVar)) {
                        att.remove(eVar);
                        this.cQh.ats().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.cQt) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void atN() {
        this.cQt = true;
        synchronized (this) {
            for (Map.Entry<String, ab> entry : this.cQz.entrySet()) {
                entry.getValue().aue();
            }
            this.cQz.clear();
        }
    }
}
