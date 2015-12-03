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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import com.baidu.tieba.signall.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends BaseAdapter implements AbsListView.OnScrollListener, ab.a {
    private c dpZ;
    private boolean dqm;
    private SignAllForumActivity dqr;
    private ArrayList<e> mDatas = new ArrayList<>();
    private HashMap<String, ab> dqs = new HashMap<>();
    private boolean aVg = true;

    public n(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.dqr = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.dpZ = cVar;
            this.mDatas = cVar.azu();
            if (this.mDatas.size() == 0) {
                this.aVg = false;
            } else {
                this.aVg = true;
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
        if (this.aVg) {
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

    private View md(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.dqr.getPageContext().getPageActivity()).inflate(n.g.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.dqy = (BarImageView) inflate.findViewById(n.f.signallforum_item_avatar);
            bVar.dqy.setIsRound(false);
            bVar.dqy.setGifIconSupport(false);
            bVar.dqA = (TextView) inflate.findViewById(n.f.signallforum_item_name);
            bVar.dqB = (ImageView) inflate.findViewById(n.f.signallforum_item_level);
            bVar.dqC = (TextView) inflate.findViewById(n.f.signallforum_item_exp);
            bVar.dqD = (FrameLayout) inflate.findViewById(n.f.signallforum_item_res_container);
            bVar.dqE = (TextView) inflate.findViewById(n.f.signallforum_item_days);
            bVar.dqF = (RelativeLayout) inflate.findViewById(n.f.signallforum_item_resign_container);
            bVar.dqG = (ImageView) inflate.findViewById(n.f.signallforum_item_resign_icon);
            bVar.dqH = (ProgressBar) inflate.findViewById(n.f.signallforum_item_resign_progress);
            bVar.dqI = (TextView) inflate.findViewById(n.f.signallforum_item_resign_text);
            bVar.dqJ = (TextView) inflate.findViewById(n.f.signallforum_item_error);
            bVar.dqz = (LinearLayout) inflate.findViewById(n.f.signallforum_item_level_container);
            bVar.dqK = (TextView) inflate.findViewById(n.f.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.dqr.getPageContext().getPageActivity()).inflate(n.g.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.dqw = (TextView) inflate2.findViewById(n.f.signallforum_head_title);
        aVar.dqx = (TextView) inflate2.findViewById(n.f.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.dqr.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dqr.getLayoutMode().k(view);
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
            bVar.dqA.setText(str);
            as.c(bVar.dqB, com.baidu.tbadk.core.util.c.cq(eVar.RI()));
            bVar.dqC.setText(String.valueOf(eVar.azH()) + "/" + eVar.azI());
            bVar.dqK.clearAnimation();
            if (eVar.azJ()) {
                bVar.dqz.setVisibility(0);
                bVar.dqJ.setVisibility(8);
                bVar.dqE.setVisibility(0);
                bVar.dqF.setVisibility(8);
                bVar.dqE.setText(String.format(this.dqr.getPageContext().getString(n.i.signallforum_days), Integer.valueOf(eVar.azG())));
                if (eVar.azN()) {
                    bVar.dqC.setText(this.dqr.getPageContext().getString(n.i.signallforum_uplevel));
                    bVar.dqK.setVisibility(8);
                } else {
                    bVar.dqC.setText(String.valueOf(eVar.azH()) + "/" + eVar.azI());
                    bVar.dqK.setVisibility(0);
                }
                int azM = eVar.azM();
                if (azM > 0) {
                    bVar.dqK.setVisibility(0);
                    bVar.dqK.setText("+" + azM);
                } else {
                    bVar.dqK.setVisibility(8);
                }
            } else if (eVar.azK()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.dqz.setVisibility(8);
                    bVar.dqJ.setVisibility(0);
                    bVar.dqK.setVisibility(8);
                    bVar.dqJ.setText(errorMsg);
                } else {
                    bVar.dqz.setVisibility(0);
                    bVar.dqJ.setVisibility(8);
                    bVar.dqK.setVisibility(8);
                }
                bVar.dqE.setVisibility(8);
                bVar.dqF.setVisibility(0);
                if (eVar.azL()) {
                    bVar.dqG.setVisibility(4);
                    bVar.dqH.setVisibility(0);
                    bVar.dqI.setText(n.i.signallforum_resigning);
                } else {
                    bVar.dqG.setVisibility(0);
                    bVar.dqH.setVisibility(4);
                    bVar.dqI.setText(n.i.signallforum_resign);
                }
                bVar.dqF.setOnClickListener(new o(this, eVar, bVar));
            } else {
                bVar.dqE.setVisibility(8);
                bVar.dqF.setVisibility(8);
                bVar.dqK.setVisibility(8);
                bVar.dqz.setVisibility(0);
                bVar.dqJ.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.dqy.setTag(avatar);
            bVar.dqy.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.aVg) {
            return LD();
        }
        int itemViewType = getItemViewType(i);
        View md = view == null ? md(itemViewType) : view;
        if (itemViewType == 1) {
            if (md.getTag() != null && (md.getTag() instanceof a)) {
                view2 = md;
                aVar = (a) md.getTag();
            } else {
                View md2 = md(itemViewType);
                view2 = md2;
                aVar = (a) md2.getTag();
            }
            this.dqr.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.dqr.getLayoutMode().k(view2.findViewById(n.f.sign_all_forum_tip));
            aVar.dqw.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            t(aVar.dqx, i);
            return view2;
        }
        if (md.getTag() == null || !(md.getTag() instanceof b)) {
            md = md(itemViewType);
        }
        a(md, viewGroup, i);
        return md;
    }

    private void t(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.dpZ == null ? 7 : this.dpZ.getLevel();
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
                    if (next.RI() >= level) {
                        if (next.azJ()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.azJ()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.dqr.getPageContext().getString(n.i.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.dqr.getPageContext().getString(n.i.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View LD() {
        View inflate = LayoutInflater.from(this.dqr.getPageContext().getPageActivity()).inflate(n.g.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.n a2 = NoDataViewFactory.a(this.dqr.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(n.f.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.D(n.i.sign_all_forum_nodata_tip, n.i.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.dqr.getLayoutMode().af(skinType == 1);
        this.dqr.getLayoutMode().k(inflate);
        a2.onChangeSkinType(this.dqr.getPageContext(), skinType);
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
        public TextView dqA;
        public ImageView dqB;
        public TextView dqC;
        public FrameLayout dqD;
        public TextView dqE;
        public RelativeLayout dqF;
        public ImageView dqG;
        public ProgressBar dqH;
        public TextView dqI;
        public TextView dqJ;
        public TextView dqK;
        public BarImageView dqy;
        public LinearLayout dqz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView dqw;
        public TextView dqx;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.dqs.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void bf(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.dqr.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.dqs.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.mDatas.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.mDatas.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.gY(z);
                eVar.gZ(!z);
                eVar.ha(false);
                if (z) {
                    eVar.mb(signData.getCountSignNum());
                    eVar.mc(signData.getBonusPoint());
                    eVar.ma(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> azx = this.dpZ.azx();
                    if (azx.contains(eVar)) {
                        azx.remove(eVar);
                        this.dpZ.azw().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.dqm) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void azR() {
        this.dqm = true;
        synchronized (this) {
            for (Map.Entry<String, ab> entry : this.dqs.entrySet()) {
                entry.getValue().aAi();
            }
            this.dqs.clear();
        }
    }
}
