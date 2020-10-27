package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements q, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private OriginalThreadInfo eAy;
    private Item eBp;
    private TbRichTextVoiceInfo eRt;
    private List<HeadItem> evZ;
    private SkinInfo ezS;
    private String ezV;
    private SmallTailInfo lDT;
    private String lhB;
    public int locate;
    private String mQV;
    private ArrayList<PostData> mQZ;
    public AlaLiveInfoCoreData mRB;
    private boolean mRF;
    public aq mRJ;
    public List<PbContent> mRM;
    private com.baidu.tbadk.data.c mRh;
    private com.baidu.tbadk.data.f mRi;
    private i mRl;
    private bs mRm;
    public boolean mRo;
    private com.baidu.tbadk.widget.richText.j mRp;
    private String mRq;
    private String mRr;
    private TPointPost mRs;
    public int mRv;
    public boolean mRy;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId mQM = BdUniqueId.gen();
    public static final BdUniqueId mQN = BdUniqueId.gen();
    public static final BdUniqueId ezT = BdUniqueId.gen();
    public static final BdUniqueId eya = BdUniqueId.gen();
    public static final BdUniqueId eyg = BdUniqueId.gen();
    public static final BdUniqueId mQO = BdUniqueId.gen();
    public static final BdUniqueId mQP = BdUniqueId.gen();
    public static final BdUniqueId mQQ = BdUniqueId.gen();
    public static final BdUniqueId mQR = BdUniqueId.gen();
    public static final BdUniqueId mQS = BdUniqueId.gen();
    public static boolean mQT = false;
    private int mQU = 0;
    private boolean mRa = false;
    private ArrayList<PostData> mRb = null;
    private TbRichText mRd = null;
    private boolean mRg = false;
    private boolean mRj = false;
    private boolean mRk = false;
    public boolean mRn = false;
    public int ezs = 0;
    private boolean mRt = false;
    public boolean iKn = false;
    public boolean mRu = false;
    public boolean mRw = false;
    public boolean mRx = true;
    public boolean mRz = false;
    public boolean mRA = false;
    private boolean mRC = false;
    private int mRD = 0;
    private boolean mRE = true;
    public boolean mRG = false;
    public boolean mRH = false;
    public boolean mRI = false;
    public boolean mRK = false;
    public boolean mRL = false;
    private b mRN = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.mRJ != null) {
                aq boJ = PostData.this.mRJ.boJ();
                boJ.delete("obj_locate");
                boJ.aj("obj_locate", 7);
                TiebaStatic.log(boJ);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eyV = new MetaData();
    private ArrayList<l> mQW = new ArrayList<>();
    private ArrayList<l> mQX = new ArrayList<>();
    private int mQY = 0;
    private int ezD = 0;
    private PraiseData ezg = new PraiseData();
    private ax mRe = new ax();
    private c mRf = new c();
    private ArrayList<com.baidu.tbadk.data.c> ezP = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.mQZ = null;
        this.mRv = 0;
        this.mQZ = new ArrayList<>();
        this.mRv = 0;
    }

    public void xh(boolean z) {
        this.mRF = z;
    }

    public boolean dHp() {
        return this.mRF;
    }

    public ArrayList<PostData> dHq() {
        return this.mRb;
    }

    public void dHr() {
        this.mRb.clear();
        this.mRb = null;
        this.mRa = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.mRb == null) {
                this.mRb = new ArrayList<>();
                if (y.getCount(this.mQZ) > 2) {
                    this.mRb.addAll(y.subList(this.mQZ, 0, 2));
                } else {
                    this.mRb.addAll(this.mQZ);
                }
            }
            this.mRb.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.mQZ != null) {
            this.mQZ.add(postData);
            dHv();
        }
    }

    public void SA(String str) {
        if (this.mRb != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.mRb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.mRb.remove(next);
                    return;
                }
            }
        }
    }

    public void xi(boolean z) {
        this.mRE = z;
    }

    public boolean dHs() {
        return this.mRE;
    }

    public void xj(boolean z) {
        this.mRa = z;
    }

    public boolean dHt() {
        return this.mRa;
    }

    public ArrayList<PostData> dHu() {
        return this.mQZ;
    }

    public void dHv() {
        this.mQY++;
    }

    public void dHw() {
        this.mQY--;
    }

    public void Jp(int i) {
        this.mQY = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dHx() {
        return this.floor_num;
    }

    public void Jq(int i) {
        this.floor_num = i;
    }

    public boolean dHy() {
        return this.mRk;
    }

    public void xk(boolean z) {
        this.mRk = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData bka() {
        return this.eyV;
    }

    public void a(MetaData metaData) {
        this.eyV = metaData;
    }

    public void a(PraiseData praiseData) {
        this.ezg = praiseData;
    }

    public TbRichText dHz() {
        return this.mRd;
    }

    public void c(TbRichText tbRichText) {
        this.mRd = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dnF() {
        return this.lDT;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.lDT = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dHA() {
        return this.mRi;
    }

    public SkinInfo bkw() {
        return this.ezS;
    }

    public void xl(boolean z) {
        this.mRC = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.mRd != null && this.mRd.bDj() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.eyV != null && this.eyV.getIs_bawu() == 1) {
                    if (this.mRF) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eyV.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eyV.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eyV.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eyV.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bka().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mS().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.mS().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.mRd.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.eyV.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eyV.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eyV == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.eyV.getName_show() + str + "：");
                str2 = this.eyV.getUserName();
                str3 = this.eyV.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eyV.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eyV.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.mRN), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eyV != null && this.eyV.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b f = f(z, this.eyV != null && this.eyV.getIs_bawu() == 1, str);
                if (f != null) {
                    if (this.eyV != null) {
                        int i3 = 0;
                        if (this.eyV.getName_show() != null) {
                            i3 = this.eyV.getName_show().length();
                        }
                        spannableString.setSpan(f, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(f, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bDj = this.mRd.bDj();
            if (bDj != null && bDj.size() > 0) {
                TbRichTextData tbRichTextData2 = bDj.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bDq() != null) {
                    if (this.mRC) {
                        int indexOf = tbRichTextData2.bDq().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bDq().delete(0, indexOf + 1);
                        }
                        this.mRC = false;
                    }
                    tbRichTextData2.sp(sb.length());
                    tbRichTextData2.bDq().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bDj.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bDj.get(i5) == null || bDj.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bDr = bDj.get(i5).bDr();
                            bDj.remove(i5);
                            tbRichTextVoiceInfo = bDr;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.sp(sb.length());
                    tbRichTextData.o(spannableString);
                    bDj.add(0, tbRichTextData);
                }
            }
            this.mRG = true;
        }
    }

    private com.baidu.tbadk.core.view.b f(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.jb(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.pu(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.Ca(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dHB() {
        return this.mQY;
    }

    public void fS(Context context) {
        int type;
        int i;
        int i2;
        if (this.mQW != null) {
            int i3 = -1;
            int size = this.mQX.size();
            if (size > 0) {
                try {
                    i3 = this.mQX.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.mQW.size()) {
                l lVar = this.mQW.get(i4);
                if (l.dr(i5, lVar.getType())) {
                    this.mQX.get(size - 1).b(lVar.fR(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.mQX.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fR(context));
                        this.mQX.add(lVar2);
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

    public void fT(Context context) {
        try {
            if (this.mRd != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.mRd.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.mQX == null || this.mQX.size() == 0) {
                fS(context);
            }
            ArrayList<l> arrayList = this.mQX;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dHh() != null) {
                            sb.append((CharSequence) next.dHh());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String Dr = TbFaceManager.byD().Dr(next.getText());
                        if (Dr != null) {
                            sb.append("[");
                            sb.append(Dr);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dHg())) {
                        sb.append("[").append(next.dHg()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
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
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.mRj = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eyV = metaData;
                }
                if (this.eyV.getUserId() == null || this.eyV.getUserId().length() <= 0 || this.eyV.getUserId().equals("0")) {
                    this.eyV = metaData2;
                }
                this.mRd = TbRichTextView.a(context, subPostList.content, z);
                if (this.mRd != null) {
                    this.mRd.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.mQV = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eyV = metaData;
                }
                this.iKn = post.need_log.intValue() == 1;
                this.mRu = post.img_num_abtest.intValue() == 1;
                this.mRm = new bs();
                this.mRm.parserProtobuf(post.from_forum);
                if (this.eyV.getUserId() == null || this.eyV.getUserId().length() <= 0 || this.eyV.getUserId().equals("0")) {
                    this.eyV.parserProtobuf(post.author);
                }
                if (this.eyV != null && context != null) {
                    this.mRq = this.eyV.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.mRr = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eyV.getLevel_id()));
                }
                this.mRg = post.is_ntitle.intValue() == 1;
                this.mQY = post.sub_post_number.intValue();
                this.mRl = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.mRM = post.content;
                this.mRK = post.is_wonderful_post.intValue() == 1;
                this.mRH = post.is_top_agree_post.intValue() == 1;
                this.evZ = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eBp = post.item;
                }
                this.mRd = TbRichTextView.a(context, list, true);
                if (this.mRd != null) {
                    this.mRd.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.mRd.so(this.floor_num);
                    if (this.eyV != null) {
                        this.mRd.setAuthorId(this.eyV.getUserId());
                    }
                    int count = y.getCount(this.evZ);
                    if (this.floor_num == 1 && count != 0 && this.evZ != null) {
                        ArrayList<TbRichTextData> bDj = this.mRd.bDj();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bDj, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bDj, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.evZ, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.p(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.evZ.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.evZ.get(size);
                                if (headItem2 != null) {
                                    a(bDj, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eBp != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eBp));
                        y.add(this.mRd.bDj(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.mRj = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.xh(this.mRF);
                            postData.a(subPostList, context);
                            this.mQZ.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.mRf.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.mRh = new com.baidu.tbadk.data.c();
                    this.mRh.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.mRi = new com.baidu.tbadk.data.f();
                    this.mRi.a(post.lbs_info);
                }
                this.ezD = post.storecount.intValue();
                this.mRe.a(post.present);
                this.ezg.setUserMap(this.userMap);
                this.ezg.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.lDT = new SmallTailInfo();
                    this.lDT.id = post.signature.signature_id.intValue();
                    this.lDT.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.lDT.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.lDT.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.lDT.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.ezP.add(cVar);
                    }
                }
                this.ezS = post.skin_info;
                this.ezV = post.lego_card;
                this.mRs = post.tpoint_post;
                if (post.agree != null) {
                    this.mRt = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.mRt = false;
                }
                this.mRA = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eAy = new OriginalThreadInfo();
                    this.eAy.a(post.origin_thread_info);
                } else {
                    this.eAy = null;
                }
                this.mRD = post.is_fold.intValue();
                this.lhB = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.o(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> mRT;
        private b mRU;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.mRT = new SoftReference<>(context);
            this.mRU = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mRT != null && this.mRT.get() != null) {
                if (this.mRU != null) {
                    this.mRU.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mRT.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fU(Context context) {
        ArrayList<TbRichTextData> bDj;
        if (this.mRd == null || (bDj = this.mRd.bDj()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bDj.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bDq().toString());
            } else if (next.getType() == 17) {
                String str = next.bDu().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String dHC() {
        ArrayList<TbRichTextData> bDj;
        String str;
        if (this.mRd == null || (bDj = this.mRd.bDj()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bDj.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bDq().toString());
                } else if (next.getType() == 17) {
                    if (next.bDu() != null && next.bDu().mGifInfo != null && (str = next.bDu().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dHD() {
        ArrayList<TbRichTextData> bDj;
        if (this.mRd != null && (bDj = this.mRd.bDj()) != null) {
            Iterator<TbRichTextData> it = bDj.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bDp().getWidth();
                    preLoadImageInfo.height = next.bDp().getHeight();
                    preLoadImageInfo.imgUrl = next.bDp().bDF();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bDv().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bDv().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bDv().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dHE() {
        k dHe;
        PreLoadImageInfo dHD = dHD();
        if (dHD != null && !StringUtils.isNull(dHD.imgUrl)) {
            return dHD.imgUrl;
        }
        if (this.mRl != null && (dHe = this.mRl.dHe()) != null && !StringUtils.isNull(dHe.dHf())) {
            return dHe.dHf();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bDj;
        if (this.mRd == null || (bDj = this.mRd.bDj()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bDj.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bDp().getWidth();
                preLoadImageInfo.height = next.bDp().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bDp().bDK()) {
                    preLoadImageInfo.imgUrl = next.bDp().bDG();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bDp().bDF();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bDu() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bDu().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bDu().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bDu();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.eyV == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eyV.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.mQU == 52) {
            return mQQ;
        }
        if (this.mQU == 1) {
            return ezT;
        }
        if (this.mQU == 36) {
            return eya;
        }
        if (this.mQU == 40 || this.mQU == 50) {
            return eyg;
        }
        if (this.mQU == 41) {
            return mQO;
        }
        if (this.mQU == 53) {
            return mQR;
        }
        if (dHx() == 1) {
            return mQM;
        }
        return mQN;
    }

    public void setPostType(int i) {
        this.mQU = i;
    }

    public ax dHF() {
        return this.mRe;
    }

    public void a(ax axVar) {
        this.mRe = axVar;
    }

    public i dHG() {
        return this.mRl;
    }

    public com.baidu.tbadk.widget.richText.j bDt() {
        if (this.mRp != null) {
            return this.mRp;
        }
        if (this.mRd != null && y.getCount(this.mRd.bDj()) > 0) {
            Iterator<TbRichTextData> it = this.mRd.bDj().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.mRp = next.bDt();
                    return this.mRp;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bDr() {
        if (this.eRt != null) {
            return this.eRt;
        }
        if (this.mRd != null && y.getCount(this.mRd.bDj()) > 0) {
            Iterator<TbRichTextData> it = this.mRd.bDj().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.eRt = next.bDr();
                    return this.eRt;
                }
            }
        }
        return null;
    }

    public String dHH() {
        return this.mRq;
    }

    public String blk() {
        return this.ezV;
    }

    public void blm() {
        if (this.ezs == 0) {
            this.ezs = 1;
        }
    }

    public long blz() {
        return this.agreeData.disAgreeNum;
    }

    public int blB() {
        return this.agreeData.agreeType;
    }

    public AgreeData blR() {
        return this.agreeData;
    }

    public OriginalThreadInfo dHI() {
        return this.eAy;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eAy = originalThreadInfo;
    }

    public int dHJ() {
        return this.mRD;
    }

    public String dfT() {
        return this.lhB;
    }
}
