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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes7.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c nqa;
    private boolean nqn;
    private SignAllForumActivity nqy;
    private ArrayList<d> iHS = new ArrayList<>();
    private HashMap<String, SignSingleModel> nqz = new HashMap<>();
    private boolean iXC = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.nqy = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.nqa = cVar;
            this.iHS = cVar.dKM();
            if (this.iHS.size() == 0) {
                this.iXC = false;
            } else {
                this.iXC = true;
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
        if (this.iXC) {
            return this.iHS.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iHS.size() > i) {
            return this.iHS.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Jq(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.nqy.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.nqF = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.nqF.setIsRound(false);
            bVar.nqF.setGifIconSupport(false);
            bVar.nqH = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.gjO = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.nqI = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.nqJ = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.nqK = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.nqL = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.nqM = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.nqN = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.nqO = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.nqP = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.nqG = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.nqQ = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.nqy.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.nqD = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.nqE = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void b(View view, View view2, int i) {
        String str;
        this.nqy.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.nqy.getLayoutMode().onModeChanged(view);
        final b bVar = (b) view.getTag();
        final d dVar = (d) getItem(i);
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
                        str = forumName.substring(0, i3) + StringHelper.STRING_MORE;
                        break;
                    }
                }
            }
            str = forumName;
            bVar.nqH.setText(str);
            ap.setImageResource(bVar.gjO, BitmapHelper.getSmallGradeResourceIdNew(dVar.bKG()));
            bVar.nqI.setText(dVar.dKZ() + "/" + dVar.dLa());
            bVar.nqQ.clearAnimation();
            if (dVar.bSt()) {
                bVar.nqG.setVisibility(0);
                bVar.nqP.setVisibility(8);
                bVar.nqK.setVisibility(0);
                bVar.nqL.setVisibility(8);
                bVar.nqK.setText(String.format(this.nqy.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dKY())));
                if (dVar.dLe()) {
                    bVar.nqI.setText(this.nqy.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.nqQ.setVisibility(8);
                } else {
                    bVar.nqI.setText(dVar.dKZ() + "/" + dVar.dLa());
                    bVar.nqQ.setVisibility(0);
                }
                int dLd = dVar.dLd();
                if (dLd > 0) {
                    bVar.nqQ.setVisibility(0);
                    bVar.nqQ.setText("+" + dLd);
                } else {
                    bVar.nqQ.setVisibility(8);
                }
            } else if (dVar.dLb()) {
                bVar.nqG.setVisibility(0);
                bVar.nqP.setVisibility(8);
                bVar.nqQ.setVisibility(8);
                bVar.nqK.setVisibility(8);
                bVar.nqL.setVisibility(0);
                if (dVar.dLc()) {
                    bVar.nqM.setVisibility(4);
                    bVar.nqN.setVisibility(0);
                    bVar.nqO.setText(R.string.signallforum_resigning);
                } else {
                    bVar.nqM.setVisibility(0);
                    bVar.nqN.setVisibility(4);
                    bVar.nqO.setText(R.string.signallforum_resign);
                }
                bVar.nqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dLc()) {
                            bVar.nqM.setVisibility(4);
                            bVar.nqN.setVisibility(0);
                            bVar.nqO.setText(R.string.signallforum_resigning);
                            dVar.ye(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.nqy);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.nqz.put(str2, signSingleModel);
                            }
                            signSingleModel.gt(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.nqK.setVisibility(8);
                bVar.nqL.setVisibility(8);
                bVar.nqQ.setVisibility(8);
                bVar.nqG.setVisibility(0);
                bVar.nqP.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.nqF.setTag(avatar);
            bVar.nqF.setPlaceHolder(1);
            bVar.nqF.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (!this.iXC) {
            return czw();
        }
        int itemViewType = getItemViewType(i);
        View Jq = view == null ? Jq(itemViewType) : view;
        if (itemViewType == 1) {
            if (Jq.getTag() != null && (Jq.getTag() instanceof a)) {
                aVar = (a) Jq.getTag();
            } else {
                Jq = Jq(itemViewType);
                aVar = (a) Jq.getTag();
            }
            this.nqy.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.nqy.getLayoutMode().onModeChanged(Jq.findViewById(R.id.sign_all_forum_tip));
            aVar.nqD.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            k(aVar.nqE, i);
            return Jq;
        }
        if (Jq.getTag() == null || !(Jq.getTag() instanceof b)) {
            Jq = Jq(itemViewType);
        }
        b(Jq, viewGroup, i);
        return Jq;
    }

    private void k(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.nqa == null ? 7 : this.nqa.getLevel();
        if (this.iHS == null || this.iHS.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.iHS.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bKG() >= level) {
                        if (next.bSt()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bSt()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.nqy.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.nqy.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View czw() {
        View inflate = LayoutInflater.from(this.nqy.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.nqy.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.nqy.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dS(null, this.nqy.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.nqy.getLayoutMode().setNightMode(skinType == 1);
        this.nqy.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.nqy.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
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
    /* loaded from: classes7.dex */
    public class b {
        public ImageView gjO;
        public BarImageView nqF;
        public LinearLayout nqG;
        public TextView nqH;
        public TextView nqI;
        public FrameLayout nqJ;
        public TextView nqK;
        public RelativeLayout nqL;
        public ImageView nqM;
        public ProgressBar nqN;
        public TextView nqO;
        public TextView nqP;
        public TextView nqQ;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a {
        public TextView nqD;
        public TextView nqE;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.nqz.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void gs(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.nqy.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.nqz.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.iHS.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.iHS.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.yc(z);
                dVar.yd(!z);
                dVar.ye(false);
                if (z) {
                    dVar.Jo(signData.count_sign_num);
                    dVar.Jp(signData.sign_bonus_point);
                    dVar.Jn(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dKP = this.nqa.dKP();
                    if (dKP.contains(dVar)) {
                        dKP.remove(dVar);
                        this.nqa.dKO().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.nqn) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dLk() {
        this.nqn = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.nqz.entrySet()) {
                    entry.getValue().dLD();
                }
                this.nqz.clear();
            }
        }
    }
}
