package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
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
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
import tbclient.TogetherHi;
/* loaded from: classes.dex */
public class q implements v, al {
    private bl UB;
    private SkinInfo UE;
    private String UI;
    @Deprecated
    private String authorId;
    private String bimg_url;
    public DealInfoData dealInfoData;
    private String elO;
    private SmallTailInfo eyU;
    private com.baidu.tbadk.data.b fvC;
    private com.baidu.tbadk.data.g fvD;
    private i fvF;
    private com.baidu.tbadk.widget.richText.o fvG;
    private String fvH;
    private String fvI;
    private TPointPost fvK;
    private ArrayList<q> fvu;
    private ArrayList<q> fvx;
    private int fvy;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fvf = BdUniqueId.gen();
    public static final BdUniqueId fvg = BdUniqueId.gen();
    public static final BdUniqueId UF = BdUniqueId.gen();
    public static final BdUniqueId fvh = BdUniqueId.gen();
    public static final BdUniqueId fvi = BdUniqueId.gen();
    public static final BdUniqueId Tt = BdUniqueId.gen();
    public static final BdUniqueId fvj = BdUniqueId.gen();
    public static final BdUniqueId fvk = BdUniqueId.gen();
    public static final BdUniqueId fvl = BdUniqueId.gen();
    public static final BdUniqueId fvm = BdUniqueId.gen();
    public static final BdUniqueId fvn = BdUniqueId.gen();
    public static final BdUniqueId emz = BdUniqueId.gen();
    public static final BdUniqueId fvo = BdUniqueId.gen();
    public static final BdUniqueId fvp = BdUniqueId.gen();
    public static boolean fvq = false;
    private int fvr = 0;
    private boolean fvv = false;
    private com.baidu.tbadk.widget.richText.a dxO = null;
    private boolean fvB = false;
    private boolean fvE = false;
    public int Ue = 0;
    public boolean fvJ = false;
    private String id = null;
    private String title = null;
    private int fvs = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<l> dvA = new ArrayList<>();
    private ArrayList<l> dwq = new ArrayList<>();
    private int fvt = 0;
    private int fvw = 0;
    private int Uo = 0;
    private PraiseData TU = new PraiseData();
    private an fvz = new an();
    private c fvA = new c();
    private ArrayList<com.baidu.tbadk.data.b> UC = new ArrayList<>();

    public q() {
        this.fvu = null;
        this.fvx = null;
        this.fvu = new ArrayList<>();
        this.fvx = new ArrayList<>();
    }

    public TPointPost bjI() {
        return this.fvK;
    }

    public c bjJ() {
        return this.fvA;
    }

    public ArrayList<q> bjK() {
        return this.fvu;
    }

    public void bjL() {
        this.fvt++;
    }

    public void bjM() {
        this.fvt--;
    }

    public void rL(int i) {
        this.fvt = i;
    }

    public ArrayList<q> bjN() {
        return this.fvx;
    }

    public boolean isGiftPost() {
        return this.fvE;
    }

    public void setIsGiftPost(boolean z) {
        this.fvE = z;
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

    public String aMf() {
        return this.elO;
    }

    public int bjO() {
        return this.fvs;
    }

    public void rM(int i) {
        this.fvs = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = az.t(j);
    }

    public String bjP() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public PraiseData rF() {
        return this.TU;
    }

    public void a(PraiseData praiseData) {
        this.TU = praiseData;
    }

    public com.baidu.tbadk.widget.richText.a aAI() {
        return this.dxO;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.dxO = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.b bjQ() {
        return this.fvC;
    }

    public SmallTailInfo aRG() {
        return this.eyU;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eyU = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bjR() {
        return this.fvD;
    }

    public SkinInfo sg() {
        return this.UE;
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        z zVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cN;
        if (tbPageContext != null && this.dxO != null && this.dxO.HZ() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds36);
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
            int length = spannableString.length();
            a aVar = new a(tbPageContext.getPageActivity(), str, str2);
            if (z && (cN = av.cN(r.f.icon_floorhost)) != null) {
                int width = (cN.getWidth() * dimensionPixelSize) / cN.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> HZ = this.dxO.HZ();
            if (HZ != null && HZ.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = HZ.get(0);
                if (cVar2.If() != null) {
                    cVar2.ft(sb.length());
                    cVar2.If().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= HZ.size()) {
                        zVar = null;
                        break;
                    } else if (HZ.get(i4) == null || HZ.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        z Ig = HZ.get(i4).Ig();
                        HZ.remove(i4);
                        zVar = Ig;
                        break;
                    }
                }
                if (zVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(zVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.ft(sb.length());
                cVar.append(spannableString);
                HZ.add(0, cVar);
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

    public int bjS() {
        return this.fvt;
    }

    public int bjT() {
        return this.fvw;
    }

    public void be(Context context) {
        int type;
        int i;
        int i2;
        if (this.dvA != null) {
            int i3 = -1;
            int size = this.dwq.size();
            if (size > 0) {
                try {
                    i3 = this.dwq.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dvA.size()) {
                l lVar = this.dvA.get(i4);
                if (l.bs(i5, lVar.getType())) {
                    this.dwq.get(size - 1).a(lVar.bd(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.dwq.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.a(lVar.bd(context));
                        this.dwq.add(lVar2);
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

    public void bf(Context context) {
        try {
            if (this.dxO != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dxO.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dwq == null || this.dwq.size() == 0) {
                be(context);
            }
            ArrayList<l> arrayList = this.dwq;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.bjA() != null) {
                            sb.append((CharSequence) next.bjA());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(r.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(r.j.voice_str));
                    } else if (next.getType() == 2) {
                        String ft = TbFaceManager.Ej().ft(next.getText());
                        if (ft != null) {
                            sb.append("[");
                            sb.append(ft);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !az.isEmpty(next.bjz())) {
                        sb.append("[").append(next.bjz()).append("]");
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
                this.fvs = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = az.t(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fvE = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dxO = TbRichTextView.b(context, subPostList.content, z);
                if (this.dxO != null) {
                    this.dxO.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.fvs = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = az.t(this.time);
                this.elO = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fvH = String.valueOf(this.author.getUserName()) + context.getResources().getString(r.j.whose_head_image);
                    this.fvI = String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fvB = post.is_ntitle.intValue() == 1;
                this.fvt = post.sub_post_number.intValue();
                this.fvw = post.add_post_number.intValue();
                this.fvF = new i(post.tpoint_post);
                this.dxO = TbRichTextView.b(context, post.content, true);
                if (this.dxO != null) {
                    this.dxO.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                    this.dxO.fs(this.fvs);
                    if (this.author != null) {
                        this.dxO.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            q qVar = new q();
                            qVar.fvE = subPostList.is_giftpost.intValue() == 1;
                            qVar.setUserMap(this.userMap);
                            qVar.a(subPostList, context);
                            this.fvu.add(qVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            q qVar2 = new q();
                            qVar2.setUserMap(this.userMap);
                            qVar2.a(subPostList2, context);
                            this.fvx.add(qVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fvA.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.fvx.size() >= 5) {
                    this.fvy = 5;
                } else {
                    this.fvy = this.fvx.size();
                }
                if (post.tail_info != null) {
                    this.fvC = new com.baidu.tbadk.data.b();
                    this.fvC.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fvD = new com.baidu.tbadk.data.g();
                    this.fvD.a(post.lbs_info);
                }
                this.Uo = post.storecount.intValue();
                this.fvz.a(post.present);
                this.TU.setUserMap(this.userMap);
                this.TU.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eyU = new SmallTailInfo();
                    this.eyU.id = post.signature.signature_id.intValue();
                    this.eyU.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eyU.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.eyU.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eyU.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.UC.add(bVar);
                    }
                }
                TogetherHi togetherHi = post.high_together;
                this.UE = post.skin_info;
                if (post.pb_deal_info != null) {
                    this.dealInfoData = new DealInfoData();
                    this.dealInfoData.parserProtobuf(post.pb_deal_info);
                }
                this.UI = post.lego_card;
                this.fvK = post.tpoint_post;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fvQ;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fvQ = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(av.getColor(r.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fvQ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fvQ.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bg(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> HZ;
        if (this.dxO == null || (HZ = this.dxO.HZ()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = HZ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.If().toString());
            } else if (next.getType() == 17) {
                String str = next.Ij().axN.axo;
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

    public int bjU() {
        return this.fvy;
    }

    public void rN(int i) {
        this.fvy = i;
    }

    public ak bjV() {
        ArrayList<com.baidu.tbadk.widget.richText.c> HZ;
        if (this.dxO != null && (HZ = this.dxO.HZ()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = HZ.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ak akVar = new ak();
                    akVar.width = next.Ie().getWidth();
                    akVar.height = next.Ie().getHeight();
                    akVar.imgUrl = next.Ie().It();
                    akVar.abe = 17;
                    return akVar;
                } else if (next.getType() == 1536) {
                    if (next.In() == null || TextUtils.isEmpty(next.In().url)) {
                        return null;
                    }
                    ak akVar2 = new ak();
                    akVar2.imgUrl = next.In().url;
                    akVar2.abe = 17;
                    return akVar2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<ak> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> HZ;
        if (this.dxO == null || (HZ = this.dxO.HZ()) == null) {
            return null;
        }
        ArrayList<ak> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = HZ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ak akVar = new ak();
                akVar.width = next.Ie().getWidth();
                akVar.height = next.Ie().getHeight();
                akVar.imgUrl = next.Ie().It();
                akVar.abe = 17;
                arrayList.add(akVar);
            } else if (next.Ij() != null) {
                ak akVar2 = new ak();
                akVar2.width = next.Ij().axN.axr;
                akVar2.height = next.Ij().axN.axs;
                akVar2.abf = next.Ij();
                akVar2.abe = 20;
                arrayList.add(akVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fvy) {
                break;
            }
            arrayList.addAll(this.fvx.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ak akVar3 = new ak();
            akVar3.imgUrl = this.bimg_url;
            akVar3.width = 105;
            akVar3.width = 105;
            akVar3.abe = 19;
            arrayList.add(akVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ak akVar4 = new ak();
        akVar4.imgUrl = this.author.getPortrait();
        akVar4.abe = 12;
        arrayList.add(akVar4);
        if (this.fvx != null) {
            Iterator<q> it2 = this.fvx.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.fvr == 2) {
            return fvg;
        }
        if (this.fvr == 1) {
            return UF;
        }
        if (this.fvr == 36) {
            return fvi;
        }
        if (this.fvr == 40) {
            return Tt;
        }
        if (this.fvr == 41) {
            return fvm;
        }
        if (fvq) {
            if (this.fvF != null && this.fvF.fuN) {
                int bjt = this.fvF.bjt();
                if (bjt == 2) {
                    return fvj;
                }
                if (bjt == 1) {
                    return fvk;
                }
                if (bjt == 3) {
                    return fvl;
                }
                return fvh;
            } else if (this.fvr == 48) {
                return fvp;
            }
        }
        if (this.UB != null && !TextUtils.isEmpty(this.UB.getActivityName())) {
            return fvo;
        }
        return fvf;
    }

    public boolean bjW() {
        return this.fvv;
    }

    public void kN(boolean z) {
        this.fvv = z;
    }

    public void setPostType(int i) {
        this.fvr = i;
    }

    public an bjX() {
        return this.fvz;
    }

    public void a(an anVar) {
        this.fvz = anVar;
    }

    public i bjY() {
        return this.fvF;
    }

    public com.baidu.tbadk.widget.richText.o Ii() {
        if (this.fvG != null) {
            return this.fvG;
        }
        if (this.dxO != null && y.s(this.dxO.HZ()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.dxO.HZ().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fvG = next.Ii();
                    return this.fvG;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bjZ() {
        return this.UC;
    }

    public String bka() {
        return this.fvH;
    }

    public String bkb() {
        return this.fvI;
    }

    public String sH() {
        return this.UI;
    }

    public void sL() {
        if (this.Ue == 0) {
            this.Ue = 1;
        }
    }
}
