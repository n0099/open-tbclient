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
    private List<HeadItem> dZn;
    private OriginalThreadInfo edI;
    private SkinInfo edc;
    private String edf;
    private Item eeA;
    private TbRichTextVoiceInfo euJ;
    private SmallTailInfo kTz;
    private String kxt;
    public int locate;
    private bs mfA;
    public boolean mfC;
    private com.baidu.tbadk.widget.richText.j mfD;
    private String mfE;
    private String mfF;
    private TPointPost mfG;
    public int mfJ;
    public boolean mfM;
    public AlaLiveInfoCoreData mfP;
    private boolean mfT;
    public aq mfX;
    private String mfk;
    private ArrayList<PostData> mfo;
    private com.baidu.tbadk.data.c mfv;
    private com.baidu.tbadk.data.f mfw;
    private i mfz;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId mfb = BdUniqueId.gen();
    public static final BdUniqueId mfc = BdUniqueId.gen();
    public static final BdUniqueId edd = BdUniqueId.gen();
    public static final BdUniqueId ebn = BdUniqueId.gen();
    public static final BdUniqueId ebs = BdUniqueId.gen();
    public static final BdUniqueId mfd = BdUniqueId.gen();
    public static final BdUniqueId mfe = BdUniqueId.gen();
    public static final BdUniqueId mff = BdUniqueId.gen();
    public static final BdUniqueId mfg = BdUniqueId.gen();
    public static final BdUniqueId mfh = BdUniqueId.gen();
    public static boolean mfi = false;
    private int mfj = 0;
    private boolean mfp = false;
    private ArrayList<PostData> mfq = null;
    private TbRichText mfr = null;
    private boolean mfu = false;
    private boolean mfx = false;
    private boolean mfy = false;
    public boolean mfB = false;
    public int ecC = 0;
    private boolean mfH = false;
    public boolean ibQ = false;
    public boolean mfI = false;
    public boolean mfK = false;
    public boolean mfL = true;
    public boolean mfN = false;
    public boolean mfO = false;
    private boolean mfQ = false;
    private int mfR = 0;
    private boolean mfS = true;
    public boolean mfU = false;
    public boolean mfV = false;
    public boolean mfW = false;
    public boolean mfY = false;
    public boolean mfZ = false;
    private b mga = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.mfX != null) {
                aq bjm = PostData.this.mfX.bjm();
                bjm.delete("obj_locate");
                bjm.ai("obj_locate", 7);
                TiebaStatic.log(bjm);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData ecf = new MetaData();
    private ArrayList<l> mfl = new ArrayList<>();
    private ArrayList<l> mfm = new ArrayList<>();
    private int mfn = 0;
    private int ecN = 0;
    private PraiseData ecq = new PraiseData();
    private ax mfs = new ax();
    private c mft = new c();
    private ArrayList<com.baidu.tbadk.data.c> ecZ = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.mfo = null;
        this.mfJ = 0;
        this.mfo = new ArrayList<>();
        this.mfJ = 0;
    }

    public void wa(boolean z) {
        this.mfT = z;
    }

    public boolean dwC() {
        return this.mfT;
    }

    public ArrayList<PostData> dwD() {
        return this.mfq;
    }

    public void dwE() {
        this.mfq.clear();
        this.mfq = null;
        this.mfp = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.mfq == null) {
                this.mfq = new ArrayList<>();
                if (y.getCount(this.mfo) > 2) {
                    this.mfq.addAll(y.subList(this.mfo, 0, 2));
                } else {
                    this.mfq.addAll(this.mfo);
                }
            }
            this.mfq.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.mfo != null) {
            this.mfo.add(postData);
            dwI();
        }
    }

    public void QN(String str) {
        if (this.mfq != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.mfq.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.mfq.remove(next);
                    return;
                }
            }
        }
    }

    public void wb(boolean z) {
        this.mfS = z;
    }

    public boolean dwF() {
        return this.mfS;
    }

    public void wc(boolean z) {
        this.mfp = z;
    }

    public boolean dwG() {
        return this.mfp;
    }

    public ArrayList<PostData> dwH() {
        return this.mfo;
    }

    public void dwI() {
        this.mfn++;
    }

    public void dwJ() {
        this.mfn--;
    }

    public void HO(int i) {
        this.mfn = i;
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

    public int dwK() {
        return this.floor_num;
    }

    public void HP(int i) {
        this.floor_num = i;
    }

    public boolean dwL() {
        return this.mfy;
    }

    public void wd(boolean z) {
        this.mfy = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData beE() {
        return this.ecf;
    }

    public void a(MetaData metaData) {
        this.ecf = metaData;
    }

    public void a(PraiseData praiseData) {
        this.ecq = praiseData;
    }

    public TbRichText dwM() {
        return this.mfr;
    }

    public void c(TbRichText tbRichText) {
        this.mfr = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo ddk() {
        return this.kTz;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.kTz = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dwN() {
        return this.mfw;
    }

    public SkinInfo bfa() {
        return this.edc;
    }

    public void we(boolean z) {
        this.mfQ = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.mfr != null && this.mfr.bxx() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.ecf != null && this.ecf.getIs_bawu() == 1) {
                    if (this.mfT) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.ecf.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.ecf.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.ecf.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.ecf.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = beE().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mM().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.mM().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.mfr.isChanged = true;
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
            if (!StringUtils.isNull(this.ecf.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.ecf.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.ecf == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.ecf.getName_show() + str + "：");
                str2 = this.ecf.getUserName();
                str3 = this.ecf.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.ecf.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.ecf.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.mga), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.ecf != null && this.ecf.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.ecf != null && this.ecf.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.ecf != null) {
                        int i3 = 0;
                        if (this.ecf.getName_show() != null) {
                            i3 = this.ecf.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bxx = this.mfr.bxx();
            if (bxx != null && bxx.size() > 0) {
                TbRichTextData tbRichTextData2 = bxx.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bxE() != null) {
                    if (this.mfQ) {
                        int indexOf = tbRichTextData2.bxE().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bxE().delete(0, indexOf + 1);
                        }
                        this.mfQ = false;
                    }
                    tbRichTextData2.rp(sb.length());
                    tbRichTextData2.bxE().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bxx.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bxx.get(i5) == null || bxx.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bxF = bxx.get(i5).bxF();
                            bxx.remove(i5);
                            tbRichTextVoiceInfo = bxF;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.rp(sb.length());
                    tbRichTextData.n(spannableString);
                    bxx.add(0, tbRichTextData);
                }
            }
            this.mfU = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.it(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.oy(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.Az(str);
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

    public int dwO() {
        return this.mfn;
    }

    public void fE(Context context) {
        int type;
        int i;
        int i2;
        if (this.mfl != null) {
            int i3 = -1;
            int size = this.mfm.size();
            if (size > 0) {
                try {
                    i3 = this.mfm.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.mfl.size()) {
                l lVar = this.mfl.get(i4);
                if (l.dl(i5, lVar.getType())) {
                    this.mfm.get(size - 1).b(lVar.fD(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.mfm.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fD(context));
                        this.mfm.add(lVar2);
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

    public void fF(Context context) {
        try {
            if (this.mfr != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.mfr.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.mfm == null || this.mfm.size() == 0) {
                fE(context);
            }
            ArrayList<l> arrayList = this.mfm;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dwu() != null) {
                            sb.append((CharSequence) next.dwu());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String BQ = TbFaceManager.bsW().BQ(next.getText());
                        if (BQ != null) {
                            sb.append("[");
                            sb.append(BQ);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dwt())) {
                        sb.append("[").append(next.dwt()).append("]");
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
                this.mfx = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ecf = metaData;
                }
                if (this.ecf.getUserId() == null || this.ecf.getUserId().length() <= 0 || this.ecf.getUserId().equals("0")) {
                    this.ecf = metaData2;
                }
                this.mfr = TbRichTextView.a(context, subPostList.content, z);
                if (this.mfr != null) {
                    this.mfr.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.mfk = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ecf = metaData;
                }
                this.ibQ = post.need_log.intValue() == 1;
                this.mfI = post.img_num_abtest.intValue() == 1;
                this.mfA = new bs();
                this.mfA.parserProtobuf(post.from_forum);
                if (this.ecf.getUserId() == null || this.ecf.getUserId().length() <= 0 || this.ecf.getUserId().equals("0")) {
                    this.ecf.parserProtobuf(post.author);
                }
                if (this.ecf != null && context != null) {
                    this.mfE = this.ecf.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.mfF = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.ecf.getLevel_id()));
                }
                this.mfu = post.is_ntitle.intValue() == 1;
                this.mfn = post.sub_post_number.intValue();
                this.mfz = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.mfY = post.is_wonderful_post.intValue() == 1;
                this.mfV = post.is_top_agree_post.intValue() == 1;
                this.dZn = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eeA = post.item;
                }
                this.mfr = TbRichTextView.a(context, list, true);
                if (this.mfr != null) {
                    this.mfr.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.mfr.ro(this.floor_num);
                    if (this.ecf != null) {
                        this.mfr.setAuthorId(this.ecf.getUserId());
                    }
                    int count = y.getCount(this.dZn);
                    if (this.floor_num == 1 && count != 0 && this.dZn != null) {
                        ArrayList<TbRichTextData> bxx = this.mfr.bxx();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bxx, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bxx, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.dZn, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.o(com.baidu.tbadk.widget.richText.e.G(i, false));
                            }
                        } else {
                            for (int size = this.dZn.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.dZn.get(size);
                                if (headItem2 != null) {
                                    a(bxx, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eeA != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eeA));
                        y.add(this.mfr.bxx(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.mfx = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.wa(this.mfT);
                            postData.a(subPostList, context);
                            this.mfo.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.mft.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.mfv = new com.baidu.tbadk.data.c();
                    this.mfv.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.mfw = new com.baidu.tbadk.data.f();
                    this.mfw.a(post.lbs_info);
                }
                this.ecN = post.storecount.intValue();
                this.mfs.a(post.present);
                this.ecq.setUserMap(this.userMap);
                this.ecq.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.kTz = new SmallTailInfo();
                    this.kTz.id = post.signature.signature_id.intValue();
                    this.kTz.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.kTz.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.kTz.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.kTz.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.ecZ.add(cVar);
                    }
                }
                this.edc = post.skin_info;
                this.edf = post.lego_card;
                this.mfG = post.tpoint_post;
                if (post.agree != null) {
                    this.mfH = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.mfH = false;
                }
                this.mfO = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.edI = new OriginalThreadInfo();
                    this.edI.a(post.origin_thread_info);
                } else {
                    this.edI = null;
                }
                this.mfR = post.is_fold.intValue();
                this.kxt = post.fold_tip;
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
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.G(i, true));
        }
        tbRichTextData.n(spannableStringBuilder);
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
        private SoftReference<Context> mgg;
        private b mgh;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.mgg = new SoftReference<>(context);
            this.mgh = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mgg != null && this.mgg.get() != null) {
                if (this.mgh != null) {
                    this.mgh.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mgg.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fG(Context context) {
        ArrayList<TbRichTextData> bxx;
        if (this.mfr == null || (bxx = this.mfr.bxx()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bxx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bxE().toString());
            } else if (next.getType() == 17) {
                String str = next.bxI().mGifInfo.mSharpText;
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

    public String dwP() {
        ArrayList<TbRichTextData> bxx;
        String str;
        if (this.mfr == null || (bxx = this.mfr.bxx()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bxx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bxE().toString());
                } else if (next.getType() == 17) {
                    if (next.bxI() != null && next.bxI().mGifInfo != null && (str = next.bxI().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dwQ() {
        ArrayList<TbRichTextData> bxx;
        if (this.mfr != null && (bxx = this.mfr.bxx()) != null) {
            Iterator<TbRichTextData> it = bxx.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bxD().getWidth();
                    preLoadImageInfo.height = next.bxD().getHeight();
                    preLoadImageInfo.imgUrl = next.bxD().bxT();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bxJ().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bxJ().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bxJ().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dwR() {
        k dwr;
        PreLoadImageInfo dwQ = dwQ();
        if (dwQ != null && !StringUtils.isNull(dwQ.imgUrl)) {
            return dwQ.imgUrl;
        }
        if (this.mfz != null && (dwr = this.mfz.dwr()) != null && !StringUtils.isNull(dwr.dws())) {
            return dwr.dws();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bxx;
        if (this.mfr == null || (bxx = this.mfr.bxx()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bxx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bxD().getWidth();
                preLoadImageInfo.height = next.bxD().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bxD().bxY()) {
                    preLoadImageInfo.imgUrl = next.bxD().bxU();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bxD().bxT();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bxI() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bxI().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bxI().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bxI();
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
        if (this.ecf == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.ecf.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.mfj == 52) {
            return mff;
        }
        if (this.mfj == 1) {
            return edd;
        }
        if (this.mfj == 36) {
            return ebn;
        }
        if (this.mfj == 40 || this.mfj == 50) {
            return ebs;
        }
        if (this.mfj == 41) {
            return mfd;
        }
        if (this.mfj == 53) {
            return mfg;
        }
        if (dwK() == 1) {
            return mfb;
        }
        return mfc;
    }

    public void setPostType(int i) {
        this.mfj = i;
    }

    public ax dwS() {
        return this.mfs;
    }

    public void a(ax axVar) {
        this.mfs = axVar;
    }

    public i dwT() {
        return this.mfz;
    }

    public com.baidu.tbadk.widget.richText.j bxH() {
        if (this.mfD != null) {
            return this.mfD;
        }
        if (this.mfr != null && y.getCount(this.mfr.bxx()) > 0) {
            Iterator<TbRichTextData> it = this.mfr.bxx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.mfD = next.bxH();
                    return this.mfD;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bxF() {
        if (this.euJ != null) {
            return this.euJ;
        }
        if (this.mfr != null && y.getCount(this.mfr.bxx()) > 0) {
            Iterator<TbRichTextData> it = this.mfr.bxx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.euJ = next.bxF();
                    return this.euJ;
                }
            }
        }
        return null;
    }

    public String dwU() {
        return this.mfE;
    }

    public String bfO() {
        return this.edf;
    }

    public void bfQ() {
        if (this.ecC == 0) {
            this.ecC = 1;
        }
    }

    public long bgd() {
        return this.agreeData.disAgreeNum;
    }

    public int bgf() {
        return this.agreeData.agreeType;
    }

    public AgreeData bgv() {
        return this.agreeData;
    }

    public OriginalThreadInfo dwV() {
        return this.edI;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.edI = originalThreadInfo;
    }

    public int dwW() {
        return this.mfR;
    }

    public String cVx() {
        return this.kxt;
    }
}
