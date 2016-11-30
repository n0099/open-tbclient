package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ah;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
import tbclient.TogetherHi;
/* loaded from: classes.dex */
public class q implements v, aj {
    private bn UY;
    private SkinInfo Vb;
    private String Vf;
    private z aIT;
    @Deprecated
    private String authorId;
    private String bimg_url;
    public DealInfoData dealInfoData;
    private SmallTailInfo eFF;
    private String erL;
    private ArrayList<q> fCG;
    private com.baidu.tbadk.data.b fCM;
    private com.baidu.tbadk.data.g fCN;
    private i fCQ;
    private com.baidu.tbadk.widget.richText.o fCR;
    private String fCS;
    private String fCT;
    private TPointPost fCV;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fCr = BdUniqueId.gen();
    public static final BdUniqueId fCs = BdUniqueId.gen();
    public static final BdUniqueId Vc = BdUniqueId.gen();
    public static final BdUniqueId fCt = BdUniqueId.gen();
    public static final BdUniqueId TP = BdUniqueId.gen();
    public static final BdUniqueId fCu = BdUniqueId.gen();
    public static final BdUniqueId fCv = BdUniqueId.gen();
    public static final BdUniqueId fCw = BdUniqueId.gen();
    public static final BdUniqueId fCx = BdUniqueId.gen();
    public static final BdUniqueId fCy = BdUniqueId.gen();
    public static final BdUniqueId esw = BdUniqueId.gen();
    public static final BdUniqueId fCz = BdUniqueId.gen();
    public static final BdUniqueId fCA = BdUniqueId.gen();
    public static final BdUniqueId fCB = BdUniqueId.gen();
    public static boolean fCC = false;
    private int fCD = 0;
    private boolean fCH = false;
    private ArrayList<q> fCI = null;
    private com.baidu.tbadk.widget.richText.a dDs = null;
    private boolean fCL = false;
    private boolean fCO = false;
    private boolean fCP = false;
    public int UB = 0;
    public boolean fCU = false;
    private String id = null;
    private String title = null;
    private int fCE = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<l> dBf = new ArrayList<>();
    private ArrayList<l> dBU = new ArrayList<>();
    private int fCF = 0;
    private int UL = 0;
    private PraiseData Uq = new PraiseData();
    private ap fCJ = new ap();
    private c fCK = new c();
    private ArrayList<com.baidu.tbadk.data.b> UZ = new ArrayList<>();

    public q() {
        this.fCG = null;
        this.fCG = new ArrayList<>();
    }

    public ArrayList<q> bme() {
        return this.fCI;
    }

    public void t(q qVar) {
        if (qVar != null) {
            if (this.fCI == null) {
                this.fCI = new ArrayList<>();
                if (x.s(this.fCG) > 2) {
                    this.fCI.addAll(x.a(this.fCG, 0, 2));
                } else {
                    this.fCI.addAll(this.fCG);
                }
            }
            this.fCI.add(qVar);
        }
    }

    public void u(q qVar) {
        if (qVar != null && this.fCG != null) {
            this.fCG.add(qVar);
            bmj();
        }
    }

    public void rG(String str) {
        if (this.fCI != null && !StringUtils.isNull(str)) {
            Iterator<q> it = this.fCI.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fCI.remove(next);
                    return;
                }
            }
        }
    }

    public void ll(boolean z) {
        this.fCH = z;
    }

    public boolean bmf() {
        return this.fCH;
    }

    public TPointPost bmg() {
        return this.fCV;
    }

    public c bmh() {
        return this.fCK;
    }

    public ArrayList<q> bmi() {
        return this.fCG;
    }

    public void bmj() {
        this.fCF++;
    }

    public void bmk() {
        this.fCF--;
    }

    public void se(int i) {
        this.fCF = i;
    }

    public boolean isGiftPost() {
        return this.fCO;
    }

    public void setIsGiftPost(boolean z) {
        this.fCO = z;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String aNY() {
        return this.erL;
    }

    public int bml() {
        return this.fCE;
    }

    public void sf(int i) {
        this.fCE = i;
    }

    public boolean bmm() {
        return this.fCP;
    }

    public void lm(boolean z) {
        this.fCP = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ax.s(j);
    }

    public String bmn() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.Uq = praiseData;
    }

    public com.baidu.tbadk.widget.richText.a aCE() {
        return this.dDs;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.dDs = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aTO() {
        return this.eFF;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eFF = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bmo() {
        return this.fCN;
    }

    public SkinInfo si() {
        return this.Vb;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        z zVar;
        com.baidu.tbadk.widget.richText.c cVar;
        if (tbPageContext != null && this.dDs != null && this.dDs.Ic() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " 楼主" : "";
            TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new r(this, it.next(), uniqueId), 0, 1);
                    eVar.d(0, 0, TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(r.e.ds32), TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(r.e.ds32));
                    arrayList.add(eVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.author.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                Bitmap cO = at.cO(r.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                }
                ah ahVar = new ah(bitmapDrawable);
                ahVar.setOffset(com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(ahVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds28));
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(at.getColor(r.d.cp_link_tip_a));
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length() + this.author.getName_show().length() + 1, sb2.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(foregroundColorSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length(), sb2.length() + str3.length(), 17);
                    spannableString.setSpan(foregroundColorSpan, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            ArrayList<com.baidu.tbadk.widget.richText.c> Ic = this.dDs.Ic();
            if (Ic != null && Ic.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = Ic.get(0);
                if (cVar2.Ii() != null) {
                    cVar2.fw(sb.length());
                    cVar2.Ii().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Ic.size()) {
                        zVar = null;
                        break;
                    } else if (Ic.get(i4) == null || Ic.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        z Ij = Ic.get(i4).Ij();
                        Ic.remove(i4);
                        zVar = Ij;
                        break;
                    }
                }
                if (zVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(zVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.fw(sb.length());
                cVar.append(spannableString);
                Ic.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap jV;
        if (aVar == null || (jV = aVar.jV()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jV);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(r.e.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(r.e.ds36));
        return bitmapDrawable;
    }

    public int bmp() {
        return this.fCF;
    }

    public void bs(Context context) {
        int type;
        int i;
        int i2;
        if (this.dBf != null) {
            int i3 = -1;
            int size = this.dBU.size();
            if (size > 0) {
                try {
                    i3 = this.dBU.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dBf.size()) {
                l lVar = this.dBf.get(i4);
                if (l.bx(i5, lVar.getType())) {
                    this.dBU.get(size - 1).a(lVar.br(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.dBU.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.a(lVar.br(context));
                        this.dBU.add(lVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void bt(Context context) {
        try {
            if (this.dDs != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dDs.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dBU == null || this.dBU.size() == 0) {
                bs(context);
            }
            ArrayList<l> arrayList = this.dBU;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.blW() != null) {
                            sb.append((CharSequence) next.blW());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(r.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(r.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fw = TbFaceManager.Eo().fw(next.getText());
                        if (fw != null) {
                            sb.append("[");
                            sb.append(fw);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ax.isEmpty(next.blV())) {
                        sb.append("[").append(next.blV()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.fCE = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ax.s(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fCO = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dDs = TbRichTextView.b(context, subPostList.content, z);
                if (this.dDs != null) {
                    this.dDs.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.fCE = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ax.s(this.time);
                this.erL = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fCS = String.valueOf(this.author.getUserName()) + context.getResources().getString(r.j.whose_head_image);
                    this.fCT = String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fCL = post.is_ntitle.intValue() == 1;
                this.fCF = post.sub_post_number.intValue();
                this.fCQ = new i(post.tpoint_post);
                this.dDs = TbRichTextView.b(context, post.content, true);
                if (this.dDs != null) {
                    this.dDs.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                    this.dDs.fv(this.fCE);
                    if (this.author != null) {
                        this.dDs.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            q qVar = new q();
                            qVar.fCO = subPostList.is_giftpost.intValue() == 1;
                            qVar.setUserMap(this.userMap);
                            qVar.a(subPostList, context);
                            this.fCG.add(qVar);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fCK.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fCM = new com.baidu.tbadk.data.b();
                    this.fCM.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fCN = new com.baidu.tbadk.data.g();
                    this.fCN.a(post.lbs_info);
                }
                this.UL = post.storecount.intValue();
                this.fCJ.a(post.present);
                this.Uq.setUserMap(this.userMap);
                this.Uq.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eFF = new SmallTailInfo();
                    this.eFF.id = post.signature.signature_id.intValue();
                    this.eFF.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eFF.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eFF.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eFF.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.UZ.add(bVar);
                    }
                }
                TogetherHi togetherHi = post.high_together;
                this.Vb = post.skin_info;
                if (post.pb_deal_info != null) {
                    this.dealInfoData = new DealInfoData();
                    this.dealInfoData.parserProtobuf(post.pb_deal_info);
                }
                this.Vf = post.lego_card;
                this.fCV = post.tpoint_post;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fDb;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fDb = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(at.getColor(r.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fDb != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fDb.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bu(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ic;
        if (this.dDs == null || (Ic = this.dDs.Ic()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Ic.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Ii().toString());
            } else if (next.getType() == 17) {
                String str = next.Im().ayE.ayf;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(r.j.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(r.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(r.j.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(r.j.msglist_graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public ai bmq() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ic;
        if (this.dDs != null && (Ic = this.dDs.Ic()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = Ic.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ai aiVar = new ai();
                    aiVar.width = next.Ih().getWidth();
                    aiVar.height = next.Ih().getHeight();
                    aiVar.imgUrl = next.Ih().Iw();
                    aiVar.abD = 17;
                    return aiVar;
                } else if (next.getType() == 1536) {
                    if (next.Iq() == null || TextUtils.isEmpty(next.Iq().url)) {
                        return null;
                    }
                    ai aiVar2 = new ai();
                    aiVar2.imgUrl = next.Iq().url;
                    aiVar2.abD = 17;
                    return aiVar2;
                }
            }
            return null;
        }
        return null;
    }

    public String bmr() {
        k blL;
        ai bmq = bmq();
        if (bmq != null && !StringUtils.isNull(bmq.imgUrl)) {
            return bmq.imgUrl;
        }
        if (this.fCQ != null && (blL = this.fCQ.blL()) != null && !StringUtils.isNull(blL.blS())) {
            return blL.blS();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ic;
        if (this.dDs == null || (Ic = this.dDs.Ic()) == null) {
            return null;
        }
        ArrayList<ai> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Ic.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ai aiVar = new ai();
                aiVar.width = next.Ih().getWidth();
                aiVar.height = next.Ih().getHeight();
                aiVar.imgUrl = next.Ih().Iw();
                aiVar.abD = 17;
                arrayList.add(aiVar);
            } else if (next.Im() != null) {
                ai aiVar2 = new ai();
                aiVar2.width = next.Im().ayE.ayi;
                aiVar2.height = next.Im().ayE.ayj;
                aiVar2.abE = next.Im();
                aiVar2.abD = 20;
                arrayList.add(aiVar2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ai aiVar3 = new ai();
            aiVar3.imgUrl = this.bimg_url;
            aiVar3.width = 105;
            aiVar3.width = 105;
            aiVar3.abD = 19;
            arrayList.add(aiVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ai aiVar4 = new ai();
        aiVar4.imgUrl = this.author.getPortrait();
        aiVar4.abD = 12;
        arrayList.add(aiVar4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.fCD == 49) {
            return fCB;
        }
        if (this.fCD == 2) {
            return fCs;
        }
        if (this.fCD == 1) {
            return Vc;
        }
        if (this.fCD == 36) {
            return fCt;
        }
        if (this.fCD == 40) {
            return TP;
        }
        if (this.fCD == 41) {
            return fCx;
        }
        if (fCC) {
            if (this.fCQ != null && this.fCQ.fBZ) {
                int blP = this.fCQ.blP();
                if (blP == 2) {
                    return fCu;
                }
                if (blP == 1) {
                    return fCv;
                }
                if (blP == 3) {
                    return fCw;
                }
                return fCr;
            } else if (this.fCD == 48) {
                return fCA;
            }
        }
        if (this.UY != null && !TextUtils.isEmpty(this.UY.getActivityName())) {
            return fCz;
        }
        return fCr;
    }

    public void setPostType(int i) {
        this.fCD = i;
    }

    public ap bms() {
        return this.fCJ;
    }

    public void a(ap apVar) {
        this.fCJ = apVar;
    }

    public i bmt() {
        return this.fCQ;
    }

    public com.baidu.tbadk.widget.richText.o Il() {
        if (this.fCR != null) {
            return this.fCR;
        }
        if (this.dDs != null && x.s(this.dDs.Ic()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.dDs.Ic().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fCR = next.Il();
                    return this.fCR;
                }
            }
        }
        return null;
    }

    public z Ij() {
        if (this.aIT != null) {
            return this.aIT;
        }
        if (this.dDs != null && x.s(this.dDs.Ic()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.dDs.Ic().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aIT = next.Ij();
                    return this.aIT;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bmu() {
        return this.UZ;
    }

    public String bmv() {
        return this.fCS;
    }

    public String bmw() {
        return this.fCT;
    }

    public String sJ() {
        return this.Vf;
    }

    public void sN() {
        if (this.UB == 0) {
            this.UB = 1;
        }
    }
}
