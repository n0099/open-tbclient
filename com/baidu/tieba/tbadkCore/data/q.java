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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.aj;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.y;
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
/* loaded from: classes.dex */
public class q implements v, ai {
    private String UC;
    private SkinInfo Uy;
    private y aIm;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String dWn;
    private SmallTailInfo ejF;
    private ArrayList<q> fgK;
    private com.baidu.tbadk.data.b fgQ;
    private com.baidu.tbadk.data.g fgR;
    private i fgU;
    private com.baidu.tbadk.widget.richText.n fgV;
    private String fgW;
    private String fgX;
    private TPointPost fgZ;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fgw = BdUniqueId.gen();
    public static final BdUniqueId fgx = BdUniqueId.gen();
    public static final BdUniqueId Uz = BdUniqueId.gen();
    public static final BdUniqueId fgy = BdUniqueId.gen();
    public static final BdUniqueId Tp = BdUniqueId.gen();
    public static final BdUniqueId fgz = BdUniqueId.gen();
    public static final BdUniqueId fgA = BdUniqueId.gen();
    public static final BdUniqueId fgB = BdUniqueId.gen();
    public static final BdUniqueId fgC = BdUniqueId.gen();
    public static final BdUniqueId fgD = BdUniqueId.gen();
    public static final BdUniqueId dWU = BdUniqueId.gen();
    public static final BdUniqueId fgE = BdUniqueId.gen();
    public static final BdUniqueId fgF = BdUniqueId.gen();
    public static boolean fgG = false;
    private int fgH = 0;
    private boolean fgL = false;
    private ArrayList<q> fgM = null;
    private com.baidu.tbadk.widget.richText.a dgq = null;
    private boolean fgP = false;
    private boolean fgS = false;
    private boolean fgT = false;
    public int Ua = 0;
    public boolean fgY = false;
    private String id = null;
    private String title = null;
    private int fgI = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<l> deb = new ArrayList<>();
    private ArrayList<l> deS = new ArrayList<>();
    private int fgJ = 0;
    private int Uk = 0;
    private PraiseData TQ = new PraiseData();
    private ao fgN = new ao();
    private c fgO = new c();
    private ArrayList<com.baidu.tbadk.data.b> Uw = new ArrayList<>();

    public q() {
        this.fgK = null;
        this.fgK = new ArrayList<>();
    }

    public ArrayList<q> bfT() {
        return this.fgM;
    }

    public void t(q qVar) {
        if (qVar != null) {
            if (this.fgM == null) {
                this.fgM = new ArrayList<>();
                if (x.s(this.fgK) > 2) {
                    this.fgM.addAll(x.a(this.fgK, 0, 2));
                } else {
                    this.fgM.addAll(this.fgK);
                }
            }
            this.fgM.add(qVar);
        }
    }

    public void u(q qVar) {
        if (qVar != null && this.fgK != null) {
            this.fgK.add(qVar);
            bfY();
        }
    }

    public void qk(String str) {
        if (this.fgM != null && !StringUtils.isNull(str)) {
            Iterator<q> it = this.fgM.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fgM.remove(next);
                    return;
                }
            }
        }
    }

    public void kV(boolean z) {
        this.fgL = z;
    }

    public boolean bfU() {
        return this.fgL;
    }

    public TPointPost bfV() {
        return this.fgZ;
    }

    public c bfW() {
        return this.fgO;
    }

    public ArrayList<q> bfX() {
        return this.fgK;
    }

    public void bfY() {
        this.fgJ++;
    }

    public void bfZ() {
        this.fgJ--;
    }

    public void rh(int i) {
        this.fgJ = i;
    }

    public boolean isGiftPost() {
        return this.fgS;
    }

    public void setIsGiftPost(boolean z) {
        this.fgS = z;
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

    public String aHY() {
        return this.dWn;
    }

    public int bga() {
        return this.fgI;
    }

    public void ri(int i) {
        this.fgI = i;
    }

    public boolean bgb() {
        return this.fgT;
    }

    public void kW(boolean z) {
        this.fgT = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = av.s(j);
    }

    public String bgc() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.TQ = praiseData;
    }

    public com.baidu.tbadk.widget.richText.a avP() {
        return this.dgq;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.dgq = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aNF() {
        return this.ejF;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.ejF = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bgd() {
        return this.fgR;
    }

    public SkinInfo rZ() {
        return this.Uy;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        y yVar;
        com.baidu.tbadk.widget.richText.c cVar;
        if (tbPageContext != null && this.dgq != null && this.dgq.Hy() != null) {
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
                Bitmap cQ = ar.cQ(r.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                }
                aj ajVar = new aj(bitmapDrawable);
                ajVar.setOffset(com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(ajVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds28));
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ar.getColor(r.d.cp_link_tip_a));
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length() + this.author.getName_show().length() + 1, sb2.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(foregroundColorSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length(), sb2.length() + str3.length(), 17);
                    spannableString.setSpan(foregroundColorSpan, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            ArrayList<com.baidu.tbadk.widget.richText.c> Hy = this.dgq.Hy();
            if (Hy != null && Hy.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = Hy.get(0);
                if (cVar2.HE() != null) {
                    cVar2.fw(sb.length());
                    cVar2.HE().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Hy.size()) {
                        yVar = null;
                        break;
                    } else if (Hy.get(i4) == null || Hy.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        y HF = Hy.get(i4).HF();
                        Hy.remove(i4);
                        yVar = HF;
                        break;
                    }
                }
                if (yVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(yVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.fw(sb.length());
                cVar.append(spannableString);
                Hy.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap jV;
        if (aVar == null || (jV = aVar.jV()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jV);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(r.e.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(r.e.ds36));
        return bitmapDrawable;
    }

    public int bge() {
        return this.fgJ;
    }

    public void br(Context context) {
        int type;
        int i;
        int i2;
        if (this.deb != null) {
            int i3 = -1;
            int size = this.deS.size();
            if (size > 0) {
                try {
                    i3 = this.deS.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.deb.size()) {
                l lVar = this.deb.get(i4);
                if (l.bm(i5, lVar.getType())) {
                    this.deS.get(size - 1).a(lVar.bq(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.deS.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.a(lVar.bq(context));
                        this.deS.add(lVar2);
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

    public void bs(Context context) {
        try {
            if (this.dgq != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dgq.toString());
                clipboardManager.getText();
                return;
            }
            if (this.deS == null || this.deS.size() == 0) {
                br(context);
            }
            ArrayList<l> arrayList = this.deS;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.bfL() != null) {
                            sb.append((CharSequence) next.bfL());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(r.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(r.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fs = TbFaceManager.DW().fs(next.getText());
                        if (fs != null) {
                            sb.append("[");
                            sb.append(fs);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !av.isEmpty(next.bfK())) {
                        sb.append("[").append(next.bfK()).append("]");
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
                this.fgI = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = av.s(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fgS = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dgq = TbRichTextView.b(context, subPostList.content, z);
                if (this.dgq != null) {
                    this.dgq.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
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
                this.fgI = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = av.s(this.time);
                this.dWn = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fgW = String.valueOf(this.author.getUserName()) + context.getResources().getString(r.j.whose_head_image);
                    this.fgX = String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fgP = post.is_ntitle.intValue() == 1;
                this.fgJ = post.sub_post_number.intValue();
                this.fgU = new i(post.tpoint_post);
                this.dgq = TbRichTextView.b(context, post.content, true);
                if (this.dgq != null) {
                    this.dgq.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                    this.dgq.fv(this.fgI);
                    if (this.author != null) {
                        this.dgq.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            q qVar = new q();
                            qVar.fgS = subPostList.is_giftpost.intValue() == 1;
                            qVar.setUserMap(this.userMap);
                            qVar.a(subPostList, context);
                            this.fgK.add(qVar);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fgO.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fgQ = new com.baidu.tbadk.data.b();
                    this.fgQ.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fgR = new com.baidu.tbadk.data.g();
                    this.fgR.a(post.lbs_info);
                }
                this.Uk = post.storecount.intValue();
                this.fgN.a(post.present);
                this.TQ.setUserMap(this.userMap);
                this.TQ.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.ejF = new SmallTailInfo();
                    this.ejF.id = post.signature.signature_id.intValue();
                    this.ejF.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.ejF.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.ejF.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.ejF.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.Uw.add(bVar);
                    }
                }
                this.Uy = post.skin_info;
                this.UC = post.lego_card;
                this.fgZ = post.tpoint_post;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fhf;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fhf = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ar.getColor(r.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fhf != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fhf.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bt(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Hy;
        if (this.dgq == null || (Hy = this.dgq.Hy()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Hy.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.HE().toString());
            } else if (next.getType() == 17) {
                String str = next.HI().ayb.axC;
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

    public ah bgf() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Hy;
        if (this.dgq != null && (Hy = this.dgq.Hy()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = Hy.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ah ahVar = new ah();
                    ahVar.width = next.HD().getWidth();
                    ahVar.height = next.HD().getHeight();
                    ahVar.imgUrl = next.HD().HR();
                    ahVar.aaU = 17;
                    return ahVar;
                } else if (next.getType() == 1536) {
                    if (next.HM() == null || TextUtils.isEmpty(next.HM().url)) {
                        return null;
                    }
                    ah ahVar2 = new ah();
                    ahVar2.imgUrl = next.HM().url;
                    ahVar2.aaU = 17;
                    return ahVar2;
                }
            }
            return null;
        }
        return null;
    }

    public String bgg() {
        k bfA;
        ah bgf = bgf();
        if (bgf != null && !StringUtils.isNull(bgf.imgUrl)) {
            return bgf.imgUrl;
        }
        if (this.fgU != null && (bfA = this.fgU.bfA()) != null && !StringUtils.isNull(bfA.bfH())) {
            return bfA.bfH();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<ah> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Hy;
        if (this.dgq == null || (Hy = this.dgq.Hy()) == null) {
            return null;
        }
        ArrayList<ah> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Hy.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ah ahVar = new ah();
                ahVar.width = next.HD().getWidth();
                ahVar.height = next.HD().getHeight();
                ahVar.imgUrl = next.HD().HR();
                ahVar.aaU = 17;
                arrayList.add(ahVar);
            } else if (next.HI() != null) {
                ah ahVar2 = new ah();
                ahVar2.width = next.HI().ayb.axF;
                ahVar2.height = next.HI().ayb.axG;
                ahVar2.aaV = next.HI();
                ahVar2.aaU = 20;
                arrayList.add(ahVar2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ah ahVar3 = new ah();
            ahVar3.imgUrl = this.bimg_url;
            ahVar3.width = 105;
            ahVar3.width = 105;
            ahVar3.aaU = 19;
            arrayList.add(ahVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ah ahVar4 = new ah();
        ahVar4.imgUrl = this.author.getPortrait();
        ahVar4.aaU = 12;
        arrayList.add(ahVar4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.fgH == 49) {
            return fgF;
        }
        if (this.fgH == 2) {
            return fgx;
        }
        if (this.fgH == 1) {
            return Uz;
        }
        if (this.fgH == 36) {
            return fgy;
        }
        if (this.fgH == 40) {
            return Tp;
        }
        if (this.fgH == 41) {
            return fgC;
        }
        if (fgG) {
            if (this.fgU != null && this.fgU.fge) {
                int bfE = this.fgU.bfE();
                if (bfE == 2) {
                    return fgz;
                }
                if (bfE == 1) {
                    return fgA;
                }
                if (bfE == 3) {
                    return fgB;
                }
                return fgw;
            } else if (this.fgH == 48) {
                return fgE;
            }
        }
        return fgw;
    }

    public void setPostType(int i) {
        this.fgH = i;
    }

    public ao bgh() {
        return this.fgN;
    }

    public void a(ao aoVar) {
        this.fgN = aoVar;
    }

    public i bgi() {
        return this.fgU;
    }

    public com.baidu.tbadk.widget.richText.n HH() {
        if (this.fgV != null) {
            return this.fgV;
        }
        if (this.dgq != null && x.s(this.dgq.Hy()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.dgq.Hy().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fgV = next.HH();
                    return this.fgV;
                }
            }
        }
        return null;
    }

    public y HF() {
        if (this.aIm != null) {
            return this.aIm;
        }
        if (this.dgq != null && x.s(this.dgq.Hy()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.dgq.Hy().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aIm = next.HF();
                    return this.aIm;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bgj() {
        return this.Uw;
    }

    public String bgk() {
        return this.fgW;
    }

    public String bgl() {
        return this.fgX;
    }

    public String sy() {
        return this.UC;
    }

    public void sB() {
        if (this.Ua == 0) {
            this.Ua = 1;
        }
    }
}
