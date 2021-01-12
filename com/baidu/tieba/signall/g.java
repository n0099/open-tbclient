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
import com.baidu.tbadk.core.util.ao;
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
    private c ndM;
    private boolean ndZ;
    private SignAllForumActivity nek;
    private ArrayList<d> iAl = new ArrayList<>();
    private HashMap<String, SignSingleModel> nel = new HashMap<>();
    private boolean iPY = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.nek = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.ndM = cVar;
            this.iAl = cVar.dIl();
            if (this.iAl.size() == 0) {
                this.iPY = false;
            } else {
                this.iPY = true;
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
        if (this.iPY) {
            return this.iAl.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iAl.size() > i) {
            return this.iAl.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View IS(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.nek.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.ner = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.ner.setIsRound(false);
            bVar.ner.setGifIconSupport(false);
            bVar.neu = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.gfH = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.nev = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.f5new = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.nex = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.ney = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.nez = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.neA = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.neB = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.neC = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.nes = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.neD = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.nek.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.nep = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.neq = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void b(View view, View view2, int i) {
        String str;
        this.nek.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.nek.getLayoutMode().onModeChanged(view);
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
            bVar.neu.setText(str);
            ao.setImageResource(bVar.gfH, BitmapHelper.getSmallGradeResourceIdNew(dVar.bKd()));
            bVar.nev.setText(dVar.dIy() + "/" + dVar.dIz());
            bVar.neD.clearAnimation();
            if (dVar.bRD()) {
                bVar.nes.setVisibility(0);
                bVar.neC.setVisibility(8);
                bVar.nex.setVisibility(0);
                bVar.ney.setVisibility(8);
                bVar.nex.setText(String.format(this.nek.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dIx())));
                if (dVar.dID()) {
                    bVar.nev.setText(this.nek.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.neD.setVisibility(8);
                } else {
                    bVar.nev.setText(dVar.dIy() + "/" + dVar.dIz());
                    bVar.neD.setVisibility(0);
                }
                int dIC = dVar.dIC();
                if (dIC > 0) {
                    bVar.neD.setVisibility(0);
                    bVar.neD.setText("+" + dIC);
                } else {
                    bVar.neD.setVisibility(8);
                }
            } else if (dVar.dIA()) {
                bVar.nes.setVisibility(0);
                bVar.neC.setVisibility(8);
                bVar.neD.setVisibility(8);
                bVar.nex.setVisibility(8);
                bVar.ney.setVisibility(0);
                if (dVar.dIB()) {
                    bVar.nez.setVisibility(4);
                    bVar.neA.setVisibility(0);
                    bVar.neB.setText(R.string.signallforum_resigning);
                } else {
                    bVar.nez.setVisibility(0);
                    bVar.neA.setVisibility(4);
                    bVar.neB.setText(R.string.signallforum_resign);
                }
                bVar.ney.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dIB()) {
                            bVar.nez.setVisibility(4);
                            bVar.neA.setVisibility(0);
                            bVar.neB.setText(R.string.signallforum_resigning);
                            dVar.xL(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.nek);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.nel.put(str2, signSingleModel);
                            }
                            signSingleModel.gl(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.nex.setVisibility(8);
                bVar.ney.setVisibility(8);
                bVar.neD.setVisibility(8);
                bVar.nes.setVisibility(0);
                bVar.neC.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.ner.setTag(avatar);
            bVar.ner.setPlaceHolder(1);
            bVar.ner.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (!this.iPY) {
            return cxY();
        }
        int itemViewType = getItemViewType(i);
        View IS = view == null ? IS(itemViewType) : view;
        if (itemViewType == 1) {
            if (IS.getTag() != null && (IS.getTag() instanceof a)) {
                aVar = (a) IS.getTag();
            } else {
                IS = IS(itemViewType);
                aVar = (a) IS.getTag();
            }
            this.nek.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.nek.getLayoutMode().onModeChanged(IS.findViewById(R.id.sign_all_forum_tip));
            aVar.nep.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.neq, i);
            return IS;
        }
        if (IS.getTag() == null || !(IS.getTag() instanceof b)) {
            IS = IS(itemViewType);
        }
        b(IS, viewGroup, i);
        return IS;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.ndM == null ? 7 : this.ndM.getLevel();
        if (this.iAl == null || this.iAl.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.iAl.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bKd() >= level) {
                        if (next.bRD()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bRD()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.nek.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.nek.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View cxY() {
        View inflate = LayoutInflater.from(this.nek.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.nek.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.nek.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dX(null, this.nek.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.nek.getLayoutMode().setNightMode(skinType == 1);
        this.nek.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.nek.getPageContext(), skinType);
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
        public ImageView gfH;
        public ProgressBar neA;
        public TextView neB;
        public TextView neC;
        public TextView neD;
        public BarImageView ner;
        public LinearLayout nes;
        public TextView neu;
        public TextView nev;

        /* renamed from: new  reason: not valid java name */
        public FrameLayout f5new;
        public TextView nex;
        public RelativeLayout ney;
        public ImageView nez;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a {
        public TextView nep;
        public TextView neq;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.nel.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void gk(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.nek.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.nel.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.iAl.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.iAl.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.xJ(z);
                dVar.xK(!z);
                dVar.xL(false);
                if (z) {
                    dVar.IQ(signData.count_sign_num);
                    dVar.IR(signData.sign_bonus_point);
                    dVar.IP(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dIo = this.ndM.dIo();
                    if (dIo.contains(dVar)) {
                        dIo.remove(dVar);
                        this.ndM.dIn().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.ndZ) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dIJ() {
        this.ndZ = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.nel.entrySet()) {
                    entry.getValue().dJc();
                }
                this.nel.clear();
            }
        }
    }
}
