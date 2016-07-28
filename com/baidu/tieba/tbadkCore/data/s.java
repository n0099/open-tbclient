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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.u;
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
/* loaded from: classes.dex */
public class s implements v, al {
    private bf RH;
    private SkinInfo RK;
    private String RP;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String dXL;
    public DealInfoData dealInfoData;
    private SmallTailInfo ekE;
    private ArrayList<s> fkV;
    private ArrayList<s> fkY;
    private int fkZ;
    private com.baidu.tbadk.data.b fld;
    private com.baidu.tbadk.data.g fle;
    private i flg;
    private com.baidu.tbadk.widget.richText.o flh;
    private String fli;
    private String flj;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fkG = BdUniqueId.gen();
    public static final BdUniqueId fkH = BdUniqueId.gen();
    public static final BdUniqueId RL = BdUniqueId.gen();
    public static final BdUniqueId fkI = BdUniqueId.gen();
    public static final BdUniqueId fkJ = BdUniqueId.gen();
    public static final BdUniqueId QC = BdUniqueId.gen();
    public static final BdUniqueId fkK = BdUniqueId.gen();
    public static final BdUniqueId fkL = BdUniqueId.gen();
    public static final BdUniqueId fkM = BdUniqueId.gen();
    public static final BdUniqueId fkN = BdUniqueId.gen();
    public static final BdUniqueId fkO = BdUniqueId.gen();
    public static final BdUniqueId dYt = BdUniqueId.gen();
    public static final BdUniqueId fkP = BdUniqueId.gen();
    public static final BdUniqueId fkQ = BdUniqueId.gen();
    public static boolean fkR = false;
    private int fkS = 0;
    private boolean fkW = false;
    private com.baidu.tbadk.widget.richText.a dkG = null;
    private boolean flc = false;
    private boolean flf = false;
    public boolean flk = false;
    private String id = null;
    private String title = null;
    private int fkT = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<l> dis = new ArrayList<>();
    private ArrayList<l> dji = new ArrayList<>();
    private int fkU = 0;
    private int fkX = 0;
    private int Rv = 0;
    private PraiseData Rc = new PraiseData();
    private ak fla = new ak();
    private c flb = new c();
    private ArrayList<com.baidu.tbadk.data.b> RI = new ArrayList<>();

    public s() {
        this.fkV = null;
        this.fkY = null;
        this.fkV = new ArrayList<>();
        this.fkY = new ArrayList<>();
    }

    public c bfw() {
        return this.flb;
    }

    public ArrayList<s> bfx() {
        return this.fkV;
    }

    public void bfy() {
        this.fkU++;
    }

    public void bfz() {
        this.fkU--;
    }

    public void qX(int i) {
        this.fkU = i;
    }

    public ArrayList<s> bfA() {
        return this.fkY;
    }

    public boolean isGiftPost() {
        return this.flf;
    }

    public void setIsGiftPost(boolean z) {
        this.flf = z;
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

    public String aGL() {
        return this.dXL;
    }

    public int bfB() {
        return this.fkT;
    }

    public void qY(int i) {
        this.fkT = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ba.t(j);
    }

    public String bfC() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public PraiseData qp() {
        return this.Rc;
    }

    public void a(PraiseData praiseData) {
        this.Rc = praiseData;
    }

    public com.baidu.tbadk.widget.richText.a avx() {
        return this.dkG;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.dkG = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.b bfD() {
        return this.fld;
    }

    public SmallTailInfo aMg() {
        return this.ekE;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.ekE = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bfE() {
        return this.fle;
    }

    public SkinInfo qP() {
        return this.RK;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        z zVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cA;
        if (tbPageContext != null && this.dkG != null && this.dkG.GD() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new t(this, it.next(), uniqueId), 0, 1);
                    eVar.d(0, 0, TbadkCoreApplication.m10getInst().getApp().getResources().getDimensionPixelSize(u.e.ds32), TbadkCoreApplication.m10getInst().getApp().getResources().getDimensionPixelSize(u.e.ds32));
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
            if (z && (cA = av.cA(u.f.icon_floorhost)) != null) {
                int width = (cA.getWidth() * dimensionPixelSize) / cA.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
                bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> GD = this.dkG.GD();
            if (GD != null && GD.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = GD.get(0);
                if (cVar2.GJ() != null) {
                    cVar2.ff(sb.length());
                    cVar2.GJ().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= GD.size()) {
                        zVar = null;
                        break;
                    } else if (GD.get(i4) == null || GD.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        z GK = GD.get(i4).GK();
                        GD.remove(i4);
                        zVar = GK;
                        break;
                    }
                }
                if (zVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(zVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.ff(sb.length());
                cVar.append(spannableString);
                GD.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap ja;
        if (aVar == null || (ja = aVar.ja()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ja);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m10getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(u.e.ds36), TbadkCoreApplication.m10getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(u.e.ds36));
        return bitmapDrawable;
    }

    public int bfF() {
        return this.fkU;
    }

    public int bfG() {
        return this.fkX;
    }

    public void aU(Context context) {
        int type;
        int i;
        int i2;
        if (this.dis != null) {
            int i3 = -1;
            int size = this.dji.size();
            if (size > 0) {
                try {
                    i3 = this.dji.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dis.size()) {
                l lVar = this.dis.get(i4);
                if (l.bl(i5, lVar.getType())) {
                    this.dji.get(size - 1).a(lVar.aT(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.dji.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.a(lVar.aT(context));
                        this.dji.add(lVar2);
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

    public void aV(Context context) {
        try {
            if (this.dkG != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dkG.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dji == null || this.dji.size() == 0) {
                aU(context);
            }
            ArrayList<l> arrayList = this.dji;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.bfk() != null) {
                            sb.append((CharSequence) next.bfk());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(u.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(u.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fo = TbFaceManager.CO().fo(next.getText());
                        if (fo != null) {
                            sb.append("[");
                            sb.append(fo);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ba.isEmpty(next.bfj())) {
                        sb.append("[").append(next.bfj()).append("]");
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
                this.fkT = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ba.t(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.flf = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dkG = TbRichTextView.b(context, subPostList.content, z);
                if (this.dkG != null) {
                    this.dkG.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
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
                this.fkT = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ba.t(this.time);
                this.dXL = post.time_ex;
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
                    this.fli = String.valueOf(this.author.getUserName()) + context.getResources().getString(u.j.whose_head_image);
                    this.flj = String.format(TbadkCoreApplication.m10getInst().getString(u.j.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.flc = post.is_ntitle.intValue() == 1;
                this.fkU = post.sub_post_number.intValue();
                this.fkX = post.add_post_number.intValue();
                this.flg = new i(post.tpoint_post);
                this.dkG = TbRichTextView.b(context, post.content, true);
                if (this.dkG != null) {
                    this.dkG.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                    this.dkG.fe(this.fkT);
                    if (this.author != null) {
                        this.dkG.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            s sVar = new s();
                            sVar.flf = subPostList.is_giftpost.intValue() == 1;
                            sVar.setUserMap(this.userMap);
                            sVar.a(subPostList, context);
                            this.fkV.add(sVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            s sVar2 = new s();
                            sVar2.setUserMap(this.userMap);
                            sVar2.a(subPostList2, context);
                            this.fkY.add(sVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.flb.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.fkY.size() >= 5) {
                    this.fkZ = 5;
                } else {
                    this.fkZ = this.fkY.size();
                }
                if (post.tail_info != null) {
                    this.fld = new com.baidu.tbadk.data.b();
                    this.fld.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fle = new com.baidu.tbadk.data.g();
                    this.fle.a(post.lbs_info);
                }
                this.Rv = post.storecount.intValue();
                this.fla.a(post.present);
                this.Rc.setUserMap(this.userMap);
                this.Rc.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.ekE = new SmallTailInfo();
                    this.ekE.id = post.signature.signature_id.intValue();
                    this.ekE.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.ekE.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.ekE.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.ekE.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.RI.add(bVar);
                    }
                }
                if (post.high_together != null) {
                    this.RH = new bf();
                    this.RH.a(post.high_together);
                }
                this.RK = post.skin_info;
                if (post.pb_deal_info != null) {
                    this.dealInfoData = new DealInfoData();
                    this.dealInfoData.parserProtobuf(post.pb_deal_info);
                }
                this.RP = post.lego_card;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> flq;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.flq = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.flq != null) {
                textPaint.setColor(av.getColor(u.d.cp_link_tip_c));
            }
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.flq != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.flq.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String aW(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GD;
        if (this.dkG == null || (GD = this.dkG.GD()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = GD.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.GJ().toString());
            } else if (next.getType() == 17) {
                String str = next.GN().avd.auE;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(u.j.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(u.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(u.j.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(u.j.msglist_graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int bfH() {
        return this.fkZ;
    }

    public void qZ(int i) {
        this.fkZ = i;
    }

    public com.baidu.tbadk.core.util.ak bfI() {
        ArrayList<com.baidu.tbadk.widget.richText.c> GD;
        if (this.dkG != null && (GD = this.dkG.GD()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = GD.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak();
                    akVar.width = next.GI().getWidth();
                    akVar.height = next.GI().getHeight();
                    akVar.imgUrl = next.GI().GV();
                    akVar.Yd = 17;
                    return akVar;
                } else if (next.getType() == 1536) {
                    if (next.GR() == null || TextUtils.isEmpty(next.GR().url)) {
                        return null;
                    }
                    com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak();
                    akVar2.imgUrl = next.GR().url;
                    akVar2.Yd = 17;
                    return akVar2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<com.baidu.tbadk.core.util.ak> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> GD;
        if (this.dkG == null || (GD = this.dkG.GD()) == null) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.ak> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = GD.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak();
                akVar.width = next.GI().getWidth();
                akVar.height = next.GI().getHeight();
                akVar.imgUrl = next.GI().GV();
                akVar.Yd = 17;
                arrayList.add(akVar);
            } else if (next.GN() != null) {
                com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak();
                akVar2.width = next.GN().avd.auH;
                akVar2.height = next.GN().avd.auI;
                akVar2.Ye = next.GN();
                akVar2.Yd = 20;
                arrayList.add(akVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fkZ) {
                break;
            }
            arrayList.addAll(this.fkY.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            com.baidu.tbadk.core.util.ak akVar3 = new com.baidu.tbadk.core.util.ak();
            akVar3.imgUrl = this.bimg_url;
            akVar3.width = 105;
            akVar3.width = 105;
            akVar3.Yd = 19;
            arrayList.add(akVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        com.baidu.tbadk.core.util.ak akVar4 = new com.baidu.tbadk.core.util.ak();
        akVar4.imgUrl = this.author.getPortrait();
        akVar4.Yd = 12;
        arrayList.add(akVar4);
        if (this.fkY != null) {
            Iterator<s> it2 = this.fkY.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.fkS == 2) {
            return fkH;
        }
        if (this.fkS == 1) {
            return RL;
        }
        if (this.fkS == 36) {
            return fkJ;
        }
        if (this.fkS == 40) {
            return QC;
        }
        if (this.fkS == 41) {
            return fkN;
        }
        if (fkR) {
            if (this.flg != null && this.flg.fkn) {
                int bfd = this.flg.bfd();
                if (bfd == 2) {
                    return fkK;
                }
                if (bfd == 1) {
                    return fkL;
                }
                if (bfd == 3) {
                    return fkM;
                }
                return fkI;
            } else if (this.fkS == 48) {
                return fkQ;
            }
        }
        if (this.RH != null && !TextUtils.isEmpty(this.RH.getActivityName())) {
            return fkP;
        }
        return fkG;
    }

    public boolean bfJ() {
        return this.fkW;
    }

    public void ky(boolean z) {
        this.fkW = z;
    }

    public void setPostType(int i) {
        this.fkS = i;
    }

    public ak bfK() {
        return this.fla;
    }

    public void a(ak akVar) {
        this.fla = akVar;
    }

    public i bfL() {
        return this.flg;
    }

    public com.baidu.tbadk.widget.richText.o GM() {
        if (this.flh != null) {
            return this.flh;
        }
        if (this.dkG != null && y.s(this.dkG.GD()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.dkG.GD().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.flh = next.GM();
                    return this.flh;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bfM() {
        return this.RI;
    }

    public String bfN() {
        return this.fli;
    }

    public String bfO() {
        return this.flj;
    }

    public String rq() {
        return this.RP;
    }
}
