package com.baidu.tieba.video.meida;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
/* loaded from: classes2.dex */
public class j {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int[] hCL;
    private static final int[] hCM;
    private static final int[] hCN;
    private static final double[][] hCO;
    private static final double[] hDa;
    private ByteOrder hCG;
    private k hCH;
    private double hCI;
    private double hCJ;
    private int hCK;
    private double[][] hCP;
    private int hCQ;
    private int hCR;
    private int hCS;
    private int hCT;
    private double[] hCU;
    private int hCV;
    private boolean hCW;
    private int hCX;
    private long hCY;
    private long hCZ;

    static {
        $assertionsDisabled = !j.class.desiredAssertionStatus();
        hCL = new int[]{0, 48000, 44100, 37800, 32000, 22050, 48000, 44100};
        hCM = new int[]{1, 16, 20, 16, 16, 15, 16, 15};
        hCN = new int[]{8, 18, 27, 8, 8, 8, 10, 9};
        hCO = new double[][]{new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};
        hDa = new double[]{0.7d, 0.9d, 0.18d};
    }

    private int i(double d) {
        return d >= 0.0d ? (int) (d + 0.5d) : (int) (d - 0.5d);
    }

    public int a(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        int[] iArr = new int[97];
        int i7 = 1;
        while (i7 < 6 && i != hCL[i7]) {
            i7++;
        }
        if ((i5 == 3 || i5 == 4) && i7 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i));
        }
        i7 = (i5 == 2 || i7 == 6) ? 0 : 0;
        if (i5 == 4 && (i7 == 1 || i7 == 2)) {
            i7 += 5;
        }
        this.hCQ = i7;
        this.hCP = new double[i2];
        this.hCR = hCM[this.hCQ];
        for (int i8 = 0; i8 < i2; i8++) {
            this.hCP[i8] = new double[this.hCR];
        }
        this.hCS = i3;
        this.hCT = i4;
        this.hCU = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i9 = 0; i9 < 97; i9++) {
            iArr[i9] = random.nextInt();
        }
        switch (i6) {
            case 0:
                for (int i10 = 0; i10 < 65536; i10++) {
                    int nextInt = random.nextInt() % 97;
                    int i11 = iArr[nextInt];
                    iArr[nextInt] = random.nextInt();
                    this.hCU[i10] = ((i11 / 2.147483647E9d) - 0.5d) * d;
                }
                break;
            case 1:
                for (int i12 = 0; i12 < 65536; i12++) {
                    int nextInt2 = random.nextInt() % 97;
                    int i13 = iArr[nextInt2];
                    iArr[nextInt2] = random.nextInt();
                    int nextInt3 = random.nextInt() % 97;
                    int i14 = iArr[nextInt3];
                    iArr[nextInt3] = random.nextInt();
                    this.hCU[i12] = ((i13 / 2.147483647E9d) - (i14 / 2.147483647E9d)) * d;
                }
                break;
            case 2:
                boolean z = false;
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (int i15 = 0; i15 < 65536; i15++) {
                    if (!z) {
                        z = true;
                        int nextInt4 = random.nextInt() % 97;
                        double d4 = iArr[nextInt4] / 2.147483647E9d;
                        iArr[nextInt4] = random.nextInt();
                        if (d4 == 1.0d) {
                            d4 = 0.0d;
                        }
                        d2 = Math.sqrt(Math.log(1.0d - d4) * (-2.0d));
                        int nextInt5 = random.nextInt() % 97;
                        iArr[nextInt5] = random.nextInt();
                        d3 = 6.283185307179586d * (iArr[nextInt5] / 2.147483647E9d);
                        this.hCU[i15] = d * d2 * Math.cos(d3);
                    } else {
                        z = false;
                        this.hCU[i15] = d * d2 * Math.sin(d3);
                    }
                }
                break;
        }
        this.hCV = 0;
        if (i5 == 0 || i5 == 1) {
            return 1;
        }
        return hCN[this.hCQ];
    }

    public int a(double d, double[] dArr, int i, int i2) {
        double i3;
        if (i == 1) {
            double[] dArr2 = this.hCU;
            int i4 = this.hCV;
            this.hCV = i4 + 1;
            double d2 = dArr2[i4 & SupportMenu.USER_MASK] + d;
            if (d2 < this.hCS) {
                double d3 = d2 / this.hCS;
                if (dArr[0] >= d3) {
                    d3 = dArr[0];
                }
                dArr[0] = d3;
                d2 = this.hCS;
            }
            if (d2 > this.hCT) {
                double d4 = d2 / this.hCT;
                if (dArr[0] >= d4) {
                    d4 = dArr[0];
                }
                dArr[0] = d4;
                d2 = this.hCT;
            }
            return i(d2);
        }
        double d5 = 0.0d;
        for (int i5 = 0; i5 < this.hCR; i5++) {
            d5 += hCO[this.hCQ][i5] * this.hCP[i2][i5];
        }
        double d6 = d5 + d;
        double[] dArr3 = this.hCU;
        int i6 = this.hCV;
        this.hCV = i6 + 1;
        double d7 = d6 + dArr3[i6 & SupportMenu.USER_MASK];
        for (int i7 = this.hCR - 2; i7 >= 0; i7--) {
            this.hCP[i2][i7 + 1] = this.hCP[i2][i7];
        }
        if (d7 < this.hCS) {
            double d8 = d7 / this.hCS;
            if (dArr[0] >= d8) {
                d8 = dArr[0];
            }
            dArr[0] = d8;
            i3 = this.hCS;
            this.hCP[i2][0] = i3 - d6;
            if (this.hCP[i2][0] > 1.0d) {
                this.hCP[i2][0] = 1.0d;
            }
            if (this.hCP[i2][0] < -1.0d) {
                this.hCP[i2][0] = -1.0d;
            }
        } else if (d7 > this.hCT) {
            double d9 = d7 / this.hCT;
            if (dArr[0] >= d9) {
                d9 = dArr[0];
            }
            dArr[0] = d9;
            i3 = this.hCT;
            this.hCP[i2][0] = i3 - d6;
            if (this.hCP[i2][0] > 1.0d) {
                this.hCP[i2][0] = 1.0d;
            }
            if (this.hCP[i2][0] < -1.0d) {
                this.hCP[i2][0] = -1.0d;
            }
        } else {
            i3 = i(d7);
            this.hCP[i2][0] = i3 - d6;
        }
        return (int) i3;
    }

    private void yo(int i) {
    }

    private double j(double d) {
        if (d <= 21.0d) {
            return 0.0d;
        }
        if (d <= 50.0d) {
            return (0.5842d * Math.pow(d - 21.0d, 0.4d)) + (0.07886d * (d - 21.0d));
        }
        return 0.1102d * (d - 8.7d);
    }

    private double a(double d, int i, double d2, double d3) {
        return f.h(Math.sqrt(1.0d - (((4.0d * d) * d) / ((i - 1.0d) * (i - 1.0d)))) * d2) / d3;
    }

    private double k(double d) {
        if (d == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d) / d;
    }

    private double c(int i, double d, double d2) {
        double d3 = 1.0d / d2;
        return k(d3 * 6.283185307179586d * d * i) * 2.0d * d * d3;
    }

    private void bIz() {
        this.hCY = System.currentTimeMillis();
        this.hCZ = 0L;
        this.hCX = -1;
    }

    private void l(double d) {
        if (!this.hCW) {
            long currentTimeMillis = System.currentTimeMillis() - this.hCY;
            int i = d == 0.0d ? 0 : (int) ((currentTimeMillis * (1.0d - d)) / d);
            int i2 = (int) (100.0d * d);
            if (i2 != this.hCX || currentTimeMillis != this.hCZ) {
                System.err.printf(" %3d%% processed", Integer.valueOf(i2));
                this.hCX = i2;
            }
            if (currentTimeMillis != this.hCZ) {
                System.err.printf(", ETA =%4dmsec", Integer.valueOf(i));
                this.hCZ = currentTimeMillis;
            }
            System.err.printf("\r", new Object[0]);
            System.err.flush();
        }
    }

    private int gcd(int i, int i2) {
        while (i2 != 0) {
            int i3 = i % i2;
            i = i2;
            i2 = i3;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:251:0x0980  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0991 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d, int i6, boolean z, int i7) throws IOException {
        int i8;
        double d2;
        double d3;
        int i9;
        double d4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z2;
        int i17;
        int i18;
        double[] dArr = {0.0d};
        int i19 = 0;
        int i20 = this.hCK;
        double d5 = this.hCI;
        int gcd = gcd(i4, i5);
        int i21 = (i4 / gcd) * i5;
        if (i21 / i5 == 1) {
            i8 = 1;
        } else if ((i21 / i5) % 2 == 0) {
            i8 = 2;
        } else if ((i21 / i5) % 3 == 0) {
            i8 = 3;
        } else {
            throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i21 / i5)));
        }
        double d6 = ((((i5 * i8) / 2) - (i4 / 2)) * 2) / 2.0d;
        double d7 = (i4 / 2) + ((((i5 * i8) / 2) - (i4 / 2)) / 2.0d);
        if (d5 <= 21.0d) {
            d2 = 0.9222d;
        } else {
            d2 = (d5 - 7.95d) / 14.36d;
        }
        int i22 = (int) ((d2 * (i21 / d6)) + 1.0d);
        if (i22 % 2 == 0) {
            i22++;
        }
        double j = j(d5);
        double h = f.h(j);
        int i23 = i21 / i4;
        int i24 = (i22 / i23) + 1;
        int[] iArr = new int[i23 * i8];
        for (int i25 = 0; i25 < i23 * i8; i25++) {
            iArr[i25] = (i21 / i4) - (((i21 / (i5 * i8)) * i25) % (i21 / i4));
            if (iArr[i25] == i21 / i4) {
                iArr[i25] = 0;
            }
        }
        int[] iArr2 = new int[i23 * i8];
        int i26 = 0;
        while (true) {
            int i27 = i26;
            if (i27 >= i23 * i8) {
                break;
            }
            iArr2[i27] = iArr[i27] < i21 / (i5 * i8) ? i : 0;
            if (iArr[i27] == i21 / i4) {
                iArr[i27] = 0;
            }
            i26 = i27 + 1;
        }
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i23, i24);
        for (int i28 = -(i22 / 2); i28 <= i22 / 2; i28++) {
            dArr2[((i22 / 2) + i28) % i23][((i22 / 2) + i28) / i23] = ((a(i28, i22, j, h) * c(i28, d7, i21)) * i21) / i4;
        }
        double d8 = this.hCI;
        if (d8 <= 21.0d) {
            d3 = 0.9222d;
        } else {
            d3 = (d8 - 7.95d) / 14.36d;
        }
        int i29 = i5 * i8;
        int i30 = 1;
        while (true) {
            i9 = i20 * i30;
            if (i9 % 2 == 0) {
                i9--;
            }
            d4 = i4 / 2;
            if ((i29 * d3) / (i9 - 1) < this.hCJ) {
                break;
            }
            i30 *= 2;
        }
        double j2 = j(d8);
        double h2 = f.h(j2);
        int i31 = 1;
        while (i31 < i9) {
            i31 *= 2;
        }
        int i32 = i31 * 2;
        double[] dArr3 = new double[i32];
        int i33 = -(i9 / 2);
        while (i33 <= i9 / 2) {
            dArr3[(i9 / 2) + i33] = ((a(i33, i9, j2, h2) * c(i33, d4, i29)) / i32) * 2.0d;
            i33++;
        }
        int[] iArr3 = new int[(int) (2.0d + Math.sqrt(i32))];
        iArr3[0] = 0;
        double[] dArr4 = new double[i32 / 2];
        this.hCH.a(i32, 1, dArr3, iArr3, dArr4);
        bIz();
        int i34 = i32 / 2;
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, i, (i34 / i8) + 1);
        double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i, i32);
        ByteBuffer allocate = ByteBuffer.allocate((i34 + i24 + 2) * i * i2);
        ByteBuffer allocate2 = ByteBuffer.allocate(((i34 / i8) + 1) * i * i3);
        double[] dArr7 = new double[(i34 + i24 + 2) * i];
        double[] dArr8 = new double[((i34 / i8) + 1) * i];
        int i35 = ((i22 / 2) / (i21 / i4)) + 1;
        int i36 = 0;
        int i37 = (int) ((i9 / 2.0d) / (i29 / i5));
        boolean z3 = true;
        int i38 = i35;
        int i39 = 0;
        int i40 = 0;
        ByteBuffer byteBuffer = allocate;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        while (true) {
            int ceil = (int) (((Math.ceil((i34 * i4) / (i5 * i8)) + 1.0d) + i24) - i38);
            int i44 = ceil + i36 > i6 ? i6 - i36 : ceil;
            byteBuffer.position(0);
            byteBuffer.limit(i44 * i2 * i);
            byte[] bArr = new byte[byteBuffer.limit()];
            int read = inputStream.read(bArr);
            if (read < 0) {
                read = 0;
            }
            if (read < byteBuffer.limit()) {
                i6 = i36 + ((read / i2) * i);
            }
            byteBuffer.limit(read);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(read);
            wrap.flip();
            int i45 = read / (i2 * i);
            switch (i2) {
                case 1:
                    i10 = 0;
                    while (i10 < i45 * i) {
                        dArr7[(i * i38) + i10] = 0.007874015748031496d * (wrap.get(i10) - 128.0d);
                        i10++;
                    }
                    break;
                case 2:
                    i10 = 0;
                    while (i10 < i45 * i) {
                        dArr7[(i * i38) + i10] = 3.051850947599719E-5d * wrap.order(this.hCG).asShortBuffer().get(i10);
                        i10++;
                    }
                    break;
                case 3:
                    i10 = 0;
                    while (i10 < i45 * i) {
                        dArr7[(i * i38) + i10] = 1.1920930376163766E-7d * ((wrap.get(i10 * 3) << 0) | (wrap.get((i10 * 3) + 1) << 8) | (wrap.get((i10 * 3) + 2) << 16));
                        i10++;
                    }
                    break;
                case 4:
                    i10 = 0;
                    while (i10 < i45 * i) {
                        dArr7[(i * i38) + i10] = 4.656612875245797E-10d * wrap.order(this.hCG).asIntBuffer().get(i10);
                        i10++;
                    }
                    break;
                default:
                    i10 = i33;
                    break;
            }
            while (i10 < i * ceil) {
                dArr7[(i * i38) + i10] = 0.0d;
                i10++;
            }
            int i46 = i38 + ceil;
            int i47 = i45 + i36;
            boolean z4 = i47 >= i6;
            int i48 = ((((i42 - 1) * i4) + i21) / i21) * i;
            int i49 = 0;
            int i50 = i41;
            int i51 = i39;
            int i52 = i10;
            int i53 = i40;
            while (i49 < i) {
                int i54 = i23 * i8;
                int i55 = i48 + i49;
                switch (i24) {
                    case 7:
                        i18 = i41;
                        for (int i56 = 0; i56 < i34; i56++) {
                            int i57 = iArr[i18];
                            dArr6[i49][i56] = (dArr2[i57][0] * dArr7[(i * 0) + i55]) + (dArr2[i57][1] * dArr7[(i * 1) + i55]) + (dArr2[i57][2] * dArr7[(i * 2) + i55]) + (dArr2[i57][3] * dArr7[(i * 3) + i55]) + (dArr2[i57][4] * dArr7[(i * 4) + i55]) + (dArr2[i57][5] * dArr7[(i * 5) + i55]) + (dArr2[i57][6] * dArr7[(i * 6) + i55]);
                            i55 += iArr2[i18];
                            i18++;
                            if (i18 == i54) {
                                i18 = 0;
                            }
                        }
                        break;
                    case 8:
                    default:
                        i18 = i41;
                        for (int i58 = 0; i58 < i34; i58++) {
                            double d9 = 0.0d;
                            int i59 = iArr[i18];
                            int i60 = i55;
                            for (int i61 = 0; i61 < i24; i61++) {
                                d9 += dArr2[i59][i61] * dArr7[i60];
                                i60 += i;
                            }
                            dArr6[i49][i58] = d9;
                            i55 += iArr2[i18];
                            i18++;
                            if (i18 == i54) {
                                i18 = 0;
                            }
                        }
                        break;
                    case 9:
                        i18 = i41;
                        for (int i62 = 0; i62 < i34; i62++) {
                            int i63 = iArr[i18];
                            dArr6[i49][i62] = (dArr2[i63][0] * dArr7[(i * 0) + i55]) + (dArr2[i63][1] * dArr7[(i * 1) + i55]) + (dArr2[i63][2] * dArr7[(i * 2) + i55]) + (dArr2[i63][3] * dArr7[(i * 3) + i55]) + (dArr2[i63][4] * dArr7[(i * 4) + i55]) + (dArr2[i63][5] * dArr7[(i * 5) + i55]) + (dArr2[i63][6] * dArr7[(i * 6) + i55]) + (dArr2[i63][7] * dArr7[(i * 7) + i55]) + (dArr2[i63][8] * dArr7[(i * 8) + i55]);
                            i55 += iArr2[i18];
                            i18++;
                            if (i18 == i54) {
                                i18 = 0;
                            }
                        }
                        break;
                }
                for (int i64 = i34; i64 < i32; i64++) {
                    dArr6[i49][i64] = 0.0d;
                }
                this.hCH.a(i32, 1, dArr6[i49], iArr3, dArr4);
                dArr6[i49][0] = dArr3[0] * dArr6[i49][0];
                dArr6[i49][1] = dArr3[1] * dArr6[i49][1];
                for (int i65 = 1; i65 < i32 / 2; i65++) {
                    dArr6[i49][i65 * 2] = (dArr3[i65 * 2] * dArr6[i49][i65 * 2]) - (dArr3[(i65 * 2) + 1] * dArr6[i49][(i65 * 2) + 1]);
                    dArr6[i49][(i65 * 2) + 1] = (dArr3[(i65 * 2) + 1] * dArr6[i49][i65 * 2]) + (dArr3[i65 * 2] * dArr6[i49][(i65 * 2) + 1]);
                }
                this.hCH.a(i32, -1, dArr6[i49], iArr3, dArr4);
                int i66 = 0;
                int i67 = i40;
                while (i67 < i34) {
                    dArr8[(i66 * i) + i49] = dArr5[i49][i66] + dArr6[i49][i67];
                    i67 += i8;
                    i66++;
                }
                int i68 = i67 - i34;
                int i69 = 0;
                while (i67 < i32) {
                    dArr5[i49][i69] = dArr6[i49][i67];
                    i67 += i8;
                    i69++;
                }
                i49++;
                i51 = i66;
                i53 = i68;
                i50 = i18;
                i52 = i67;
            }
            int i70 = i42 + (((i4 / gcd) * i34) / i8);
            allocate2.clear();
            if (z) {
                i11 = 0;
                while (i11 < i51 * i) {
                    double d10 = dArr8[i11] > 0.0d ? dArr8[i11] : -dArr8[i11];
                    if (dArr[0] >= d10) {
                        d10 = dArr[0];
                    }
                    dArr[0] = d10;
                    allocate2.asDoubleBuffer().put(i11, dArr8[i11]);
                    i11++;
                }
            } else {
                switch (i3) {
                    case 1:
                        double d11 = d * 127.0d;
                        int i71 = 0;
                        int i72 = 0;
                        while (i72 < i51 * i) {
                            if (i7 != 0) {
                                i14 = a(dArr8[i72] * d11, dArr, i7, i71);
                            } else {
                                i14 = i(dArr8[i72] * d11);
                                if (i14 < -128) {
                                    double d12 = i14 / (-128.0d);
                                    if (dArr[0] >= d12) {
                                        d12 = dArr[0];
                                    }
                                    dArr[0] = d12;
                                    i14 = -128;
                                }
                                if (127 < i14) {
                                    double d13 = i14 / 127.0d;
                                    if (dArr[0] >= d13) {
                                        d13 = dArr[0];
                                    }
                                    dArr[0] = d13;
                                    i14 = 127;
                                }
                            }
                            allocate2.put(i72, (byte) (i14 + 128));
                            int i73 = i71 + 1;
                            if (i73 == i) {
                                i73 = 0;
                            }
                            i72++;
                            i71 = i73;
                        }
                        i11 = i72;
                        break;
                    case 2:
                        double d14 = d * 32767.0d;
                        int i74 = 0;
                        int i75 = 0;
                        while (i75 < i51 * i) {
                            if (i7 != 0) {
                                i13 = a(dArr8[i75] * d14, dArr, i7, i74);
                            } else {
                                i13 = i(dArr8[i75] * d14);
                                if (i13 < -32768) {
                                    double d15 = i13 / (-32768.0d);
                                    if (dArr[0] >= d15) {
                                        d15 = dArr[0];
                                    }
                                    dArr[0] = d15;
                                    i13 = -32768;
                                }
                                if (32767 < i13) {
                                    double d16 = i13 / 32767.0d;
                                    if (dArr[0] >= d16) {
                                        d16 = dArr[0];
                                    }
                                    dArr[0] = d16;
                                    i13 = 32767;
                                }
                            }
                            allocate2.order(this.hCG).asShortBuffer().put(i75, (short) i13);
                            int i76 = i74 + 1;
                            if (i76 == i) {
                                i76 = 0;
                            }
                            i75++;
                            i74 = i76;
                        }
                        i11 = i75;
                        break;
                    case 3:
                        double d17 = d * 8388607.0d;
                        int i77 = 0;
                        int i78 = 0;
                        while (i78 < i51 * i) {
                            if (i7 != 0) {
                                i12 = a(dArr8[i78] * d17, dArr, i7, i77);
                            } else {
                                i12 = i(dArr8[i78] * d17);
                                if (i12 < -8388608) {
                                    double d18 = i12 / (-8388608.0d);
                                    if (dArr[0] >= d18) {
                                        d18 = dArr[0];
                                    }
                                    dArr[0] = d18;
                                    i12 = -8388608;
                                }
                                if (8388607 < i12) {
                                    double d19 = i12 / 8388607.0d;
                                    if (dArr[0] >= d19) {
                                        d19 = dArr[0];
                                    }
                                    dArr[0] = d19;
                                    i12 = 8388607;
                                }
                            }
                            allocate2.put(i78 * 3, (byte) (i12 & 255));
                            int i79 = i12 >> 8;
                            allocate2.put((i78 * 3) + 1, (byte) (i79 & 255));
                            allocate2.put((i78 * 3) + 2, (byte) ((i79 >> 8) & 255));
                            int i80 = i77 + 1;
                            if (i80 == i) {
                                i80 = 0;
                            }
                            i78++;
                            i77 = i80;
                        }
                        i11 = i78;
                        break;
                    default:
                        i11 = i52;
                        break;
                }
            }
            if (!z3) {
                if (z4) {
                    if (((i47 * i5) / i4) + 2.0d > i43 + i51) {
                        allocate2.position(0);
                        allocate2.limit(i3 * i * i51);
                        a(outputStream, allocate2);
                        i15 = i43 + i51;
                        i16 = i37;
                        z2 = z3;
                    } else {
                        allocate2.position(0);
                        int floor = (int) (i3 * i * ((Math.floor((i47 * i5) / i4) + 2.0d) - i43));
                        if (floor > 0) {
                            allocate2.limit(floor);
                            a(outputStream, allocate2);
                        }
                    }
                } else {
                    allocate2.position(0);
                    allocate2.limit(i3 * i * i51);
                    a(outputStream, allocate2);
                    i15 = i43 + i51;
                    i16 = i37;
                    z2 = z3;
                }
                i17 = (i70 - 1) / (i21 / i4);
                if ($assertionsDisabled && i46 < i17) {
                    throw new AssertionError();
                }
                System.arraycopy(dArr7, i * i17, dArr7, 0, (i46 - i17) * i);
                int i81 = i46 - i17;
                int i82 = i70 - (i17 * (i21 / i4));
                int i83 = i19 + 1;
                if ((i19 & 7) != 7) {
                    l(i47 / i6);
                }
                i43 = i15;
                z3 = z2;
                i19 = i83;
                i37 = i16;
                i36 = i47;
                i41 = i50;
                i38 = i81;
                i33 = i11;
                i42 = i82;
                i40 = i53;
                i39 = i51;
                byteBuffer = wrap;
            } else {
                if (i51 < i37) {
                    i16 = i37 - i51;
                    i15 = i43;
                    z2 = z3;
                } else if (z4) {
                    if (((i47 * i5) / i4) + 2.0d > (i43 + i51) - i37) {
                        allocate2.position(i3 * i * i37);
                        allocate2.limit(i3 * i * i51);
                        a(outputStream, allocate2);
                        i15 = i43 + (i51 - i37);
                        i16 = i37;
                        z2 = z3;
                    } else {
                        allocate2.position(i3 * i * i37);
                        allocate2.limit((int) (i3 * i * ((Math.floor((i47 * i5) / i4) + 2.0d) - i43)));
                        a(outputStream, allocate2);
                    }
                } else {
                    allocate2.position(i3 * i * i37);
                    allocate2.limit(i3 * i * i51);
                    a(outputStream, allocate2);
                    i15 = i43 + (i51 - i37);
                    i16 = i37;
                    z2 = false;
                }
                i17 = (i70 - 1) / (i21 / i4);
                if ($assertionsDisabled) {
                }
                System.arraycopy(dArr7, i * i17, dArr7, 0, (i46 - i17) * i);
                int i812 = i46 - i17;
                int i822 = i70 - (i17 * (i21 / i4));
                int i832 = i19 + 1;
                if ((i19 & 7) != 7) {
                }
                i43 = i15;
                z3 = z2;
                i19 = i832;
                i37 = i16;
                i36 = i47;
                i41 = i50;
                i38 = i812;
                i33 = i11;
                i42 = i822;
                i40 = i53;
                i39 = i51;
                byteBuffer = wrap;
            }
        }
        l(1.0d);
        return dArr[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:251:0x08a4, code lost:
        l(1.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x08ae, code lost:
        return r0[0];
     */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x06d2 A[LOOP:18: B:180:0x06ce->B:182:0x06d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0979 A[LOOP:19: B:263:0x0975->B:265:0x0979, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0997  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x09aa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double b(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d, int i6, boolean z, int i7) throws IOException {
        int i8;
        double d2;
        int i9;
        double d3;
        double d4;
        int[] iArr;
        int[] iArr2;
        int i10;
        double[][] dArr;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        double[] dArr2 = {0.0d};
        int i23 = this.hCK;
        double d5 = this.hCI;
        int gcd = gcd(i4, i5);
        if (i5 / gcd == 1) {
            i8 = 1;
        } else if ((i5 / gcd) % 2 == 0) {
            i8 = 2;
        } else if ((i5 / gcd) % 3 == 0) {
            i8 = 3;
        } else {
            throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5 / gcd)));
        }
        int i24 = i4 * i8;
        if (d5 <= 21.0d) {
            d2 = 0.9222d;
        } else {
            d2 = (d5 - 7.95d) / 14.36d;
        }
        int i25 = 1;
        while (true) {
            i9 = i23 * i25;
            if (i9 % 2 == 0) {
                i9--;
            }
            double d6 = (i24 * d2) / (i9 - 1);
            d3 = (i5 - d6) / 2.0d;
            if (d6 < this.hCJ) {
                break;
            }
            i25 *= 2;
        }
        double j = j(d5);
        double h = f.h(j);
        int i26 = 1;
        while (i26 < i9) {
            i26 *= 2;
        }
        int i27 = i26 * 2;
        double[] dArr3 = new double[i27];
        int i28 = -(i9 / 2);
        while (i28 <= i9 / 2) {
            dArr3[i28 + (i9 / 2)] = ((((a(i28, i9, j, h) * c(i28, d3, i24)) * i24) / i4) / i27) * 2.0d;
            i28++;
        }
        int[] iArr3 = new int[(int) (2.0d + Math.sqrt(i27))];
        iArr3[0] = 0;
        double[] dArr4 = new double[i27 / 2];
        this.hCH.a(i27, 1, dArr3, iArr3, dArr4);
        if (i8 == 1) {
            int i29 = (i4 / gcd) * i5;
            double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, 1, 1);
            dArr5[0][0] = 1.0d;
            iArr = new int[]{i4 / i5};
            iArr2 = new int[]{0};
            i12 = 1;
            i10 = 1;
            dArr = dArr5;
            i11 = i29;
            i13 = 1;
        } else {
            double d7 = this.hCI;
            int i30 = (i4 / gcd) * i5;
            double d8 = (((i24 / 2) - (i4 / 2)) * 2) / 2.0d;
            double d9 = (i4 / 2) + (((i24 / 2) - (i4 / 2)) / 2.0d);
            if (d7 <= 21.0d) {
                d4 = 0.9222d;
            } else {
                d4 = (d7 - 7.95d) / 14.36d;
            }
            int i31 = (int) ((d4 * (i30 / d8)) + 1.0d);
            if (i31 % 2 == 0) {
                i31++;
            }
            double j2 = j(d7);
            double h2 = f.h(j2);
            int i32 = i30 / i24;
            int i33 = (i31 / i32) + 1;
            int[] iArr4 = new int[i32];
            for (int i34 = 0; i34 < i32; i34++) {
                iArr4[i34] = (i30 / i24) - (((i30 / i5) * i34) % (i30 / i24));
                if (iArr4[i34] == i30 / i24) {
                    iArr4[i34] = 0;
                }
            }
            int[] iArr5 = new int[i32];
            int i35 = 0;
            while (true) {
                int i36 = i35;
                if (i36 >= i32) {
                    break;
                }
                iArr5[i36] = (((i30 / i5) - iArr4[i36]) / (i30 / i24)) + 1;
                if (iArr4[i36 + 1 == i32 ? 0 : i36 + 1] == 0) {
                    iArr5[i36] = iArr5[i36] - 1;
                }
                i35 = i36 + 1;
            }
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i32, i33);
            int i37 = -(i31 / 2);
            while (i37 <= i31 / 2) {
                dArr6[((i31 / 2) + i37) % i32][((i31 / 2) + i37) / i32] = ((a(i37, i31, j2, h2) * c(i37, d9, i30)) * i30) / i24;
                i37++;
            }
            i28 = i37;
            iArr = iArr5;
            iArr2 = iArr4;
            i10 = i33;
            dArr = dArr6;
            i11 = i30;
            i12 = i32;
            i13 = i31;
        }
        bIz();
        int i38 = i27 / 2;
        double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, i, i27);
        double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, i, i10 + 1 + i38);
        ByteBuffer allocate = ByteBuffer.allocate(((i38 / i8) + i8 + 1) * i * i2);
        ByteBuffer allocate2 = ByteBuffer.allocate((int) ((((i38 * i5) / i4) + 1.0d) * i3 * i));
        double[] dArr9 = new double[((i38 / i8) + i8 + 1) * i];
        double[] dArr10 = new double[(int) (i * (((i38 * i5) / i4) + 1.0d))];
        int i39 = 0;
        int i40 = 0;
        boolean z3 = true;
        int i41 = (int) (((i13 / 2.0d) / (i11 / i5)) + ((i9 / 2.0d) / (i24 / i5)));
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i45 = 0;
        int i46 = i28;
        ByteBuffer byteBuffer = allocate;
        int i47 = i41;
        int i48 = 0;
        while (true) {
            int i49 = (((i38 - 0) - 1) / i8) + 1;
            if (i49 + i48 > i6) {
                i49 = i6 - i48;
            }
            byteBuffer.position(0);
            byteBuffer.limit(i2 * i * i49);
            byte[] bArr = new byte[byteBuffer.limit()];
            int read = inputStream.read(bArr);
            if (read < 0) {
                read = 0;
            }
            if (read < byteBuffer.limit()) {
                i6 = i48 + ((read / i2) * i);
            }
            byteBuffer.limit(read);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(read);
            wrap.flip();
            int i50 = read / (i2 * i);
            switch (i2) {
                case 1:
                    i46 = 0;
                    while (i46 < i50 * i) {
                        dArr9[(i * 0) + i46] = 0.007874015748031496d * ((wrap.get(i46) & 255) - 128);
                        i46++;
                    }
                    break;
                case 2:
                    i46 = 0;
                    while (i46 < i50 * i) {
                        dArr9[(i * 0) + i46] = 3.051850947599719E-5d * wrap.order(this.hCG).asShortBuffer().get(i46);
                        i46++;
                    }
                    break;
                case 3:
                    i46 = 0;
                    while (i46 < i50 * i) {
                        dArr9[(i * 0) + i46] = 1.1920930376163766E-7d * (((wrap.get(i46 * 3) & 255) << 0) | ((wrap.get((i46 * 3) + 1) & 255) << 8) | ((wrap.get((i46 * 3) + 2) & 255) << 16));
                        i46++;
                    }
                    break;
                case 4:
                    i46 = 0;
                    while (i46 < i50 * i) {
                        dArr9[(i * 0) + i46] = 4.656612875245797E-10d * wrap.order(this.hCG).getInt(i46);
                        i46++;
                    }
                    break;
            }
            while (i46 < i * i49) {
                dArr9[i46] = 0.0d;
                i46++;
            }
            int i51 = i48 + i50;
            boolean z4 = inputStream.available() < 0 || i51 >= i6;
            int i52 = 0;
            int i53 = i39;
            int i54 = i43;
            int i55 = i44;
            while (true) {
                int i56 = i46;
                if (i52 < i) {
                    int i57 = 0;
                    int i58 = 0;
                    while (i58 < i38) {
                        if (!$assertionsDisabled && i57 >= (((i38 - 0) - 1) / i8) + 1) {
                            throw new AssertionError();
                        }
                        dArr7[i52][i58] = dArr9[(i57 * i) + i52];
                        for (int i59 = i58 + 1; i59 < i58 + i8; i59++) {
                            dArr7[i52][i59] = 0.0d;
                        }
                        i58 += i8;
                        i57++;
                    }
                    if (!$assertionsDisabled && i57 != (((i38 - 0) - 1) / i8) + 1) {
                        throw new AssertionError();
                    }
                    for (int i60 = i38; i60 < i27; i60++) {
                        dArr7[i52][i60] = 0.0d;
                    }
                    int i61 = i58 - i38;
                    int i62 = i55 + i57;
                    this.hCH.a(i27, 1, dArr7[i52], iArr3, dArr4);
                    dArr7[i52][0] = dArr3[0] * dArr7[i52][0];
                    dArr7[i52][1] = dArr3[1] * dArr7[i52][1];
                    for (int i63 = 1; i63 < i38; i63++) {
                        double d10 = (dArr3[i63 * 2] * dArr7[i52][i63 * 2]) - (dArr3[(i63 * 2) + 1] * dArr7[i52][(i63 * 2) + 1]);
                        double d11 = (dArr3[(i63 * 2) + 1] * dArr7[i52][i63 * 2]) + (dArr3[i63 * 2] * dArr7[i52][(i63 * 2) + 1]);
                        dArr7[i52][i63 * 2] = d10;
                        dArr7[i52][(i63 * 2) + 1] = d11;
                    }
                    this.hCH.a(i27, -1, dArr7[i52], iArr3, dArr4);
                    int i64 = 0;
                    while (i64 < i38) {
                        double[] dArr11 = dArr8[i52];
                        int i65 = i10 + 1 + i64;
                        dArr11[i65] = dArr11[i65] + dArr7[i52][i64];
                        i64++;
                    }
                    int i66 = i40 / (i11 / i24);
                    if (i40 % (i11 / i24) != 0) {
                        i66++;
                    }
                    i46 = i64;
                    int length = (dArr8[0].length * i52) + i66;
                    int i67 = 0;
                    int i68 = i39;
                    while (length - (dArr8[0].length * i52) < i38 + 1) {
                        int i69 = iArr2[i68];
                        int i70 = iArr[i68] + length;
                        i68++;
                        if (i68 == i12) {
                            i68 = 0;
                        }
                        if (!$assertionsDisabled && ((length - (dArr8[0].length * i52)) * (i11 / i24)) - (((i11 / i5) * i67) + i40) != i69) {
                            throw new AssertionError();
                        }
                        int i71 = length;
                        int i72 = 0;
                        double d12 = 0.0d;
                        int i73 = i71;
                        while (i72 < i10) {
                            d12 += dArr[i69][i72] * dArr8[i73 / dArr8[0].length][i73 % dArr8[0].length];
                            i73++;
                            i72++;
                        }
                        dArr10[(i67 * i) + 0 + i52] = d12;
                        i67++;
                        i46 = i72;
                        length = i70;
                    }
                    i52++;
                    i53 = i68;
                    i54 = i67;
                    i55 = i62;
                } else {
                    int i74 = i40 + ((i11 / i5) * i54);
                    allocate2.clear();
                    if (z) {
                        i14 = 0;
                        while (i14 < i54 * i) {
                            double d13 = dArr10[i14] > 0.0d ? dArr10[i14] : -dArr10[i14];
                            if (dArr2[0] >= d13) {
                                d13 = dArr2[0];
                            }
                            dArr2[0] = d13;
                            allocate2.asDoubleBuffer().put(i14, dArr10[i14]);
                            i14++;
                        }
                    } else {
                        switch (i3) {
                            case 1:
                                double d14 = d * 127.0d;
                                int i75 = 0;
                                int i76 = 0;
                                while (i76 < i54 * i) {
                                    if (i7 != 0) {
                                        i17 = a(dArr10[i76] * d14, dArr2, i7, i75);
                                    } else {
                                        i17 = i(dArr10[i76] * d14);
                                        if (i17 < -128) {
                                            double d15 = i17 / (-128.0d);
                                            if (dArr2[0] >= d15) {
                                                d15 = dArr2[0];
                                            }
                                            dArr2[0] = d15;
                                            i17 = -128;
                                        }
                                        if (127 < i17) {
                                            double d16 = i17 / 127.0d;
                                            if (dArr2[0] >= d16) {
                                                d16 = dArr2[0];
                                            }
                                            dArr2[0] = d16;
                                            i17 = 127;
                                        }
                                    }
                                    allocate2.put(i76, (byte) (i17 + 128));
                                    int i77 = i75 + 1;
                                    if (i77 == i) {
                                        i77 = 0;
                                    }
                                    i76++;
                                    i75 = i77;
                                }
                                i14 = i76;
                                break;
                            case 2:
                                double d17 = d * 32767.0d;
                                int i78 = 0;
                                int i79 = 0;
                                while (i79 < i54 * i) {
                                    if (i7 != 0) {
                                        i16 = a(dArr10[i79] * d17, dArr2, i7, i78);
                                    } else {
                                        i16 = i(dArr10[i79] * d17);
                                        if (i16 < -32768) {
                                            double d18 = i16 / (-32768.0d);
                                            if (dArr2[0] >= d18) {
                                                d18 = dArr2[0];
                                            }
                                            dArr2[0] = d18;
                                            i16 = -32768;
                                        }
                                        if (32767 < i16) {
                                            double d19 = i16 / 32767.0d;
                                            if (dArr2[0] >= d19) {
                                                d19 = dArr2[0];
                                            }
                                            dArr2[0] = d19;
                                            i16 = 32767;
                                        }
                                    }
                                    allocate2.order(this.hCG).asShortBuffer().put(i79, (short) i16);
                                    int i80 = i78 + 1;
                                    if (i80 == i) {
                                        i80 = 0;
                                    }
                                    i79++;
                                    i78 = i80;
                                }
                                i14 = i79;
                                break;
                            case 3:
                                double d20 = d * 8388607.0d;
                                int i81 = 0;
                                int i82 = 0;
                                while (i82 < i54 * i) {
                                    if (i7 != 0) {
                                        i15 = a(dArr10[i82] * d20, dArr2, i7, i81);
                                    } else {
                                        i15 = i(dArr10[i82] * d20);
                                        if (i15 < -8388608) {
                                            double d21 = i15 / (-8388608.0d);
                                            if (dArr2[0] >= d21) {
                                                d21 = dArr2[0];
                                            }
                                            dArr2[0] = d21;
                                            i15 = -8388608;
                                        }
                                        if (8388607 < i15) {
                                            double d22 = i15 / 8388607.0d;
                                            if (dArr2[0] >= d22) {
                                                d22 = dArr2[0];
                                            }
                                            dArr2[0] = d22;
                                            i15 = 8388607;
                                        }
                                    }
                                    allocate2.put(i82 * 3, (byte) (i15 & 255));
                                    int i83 = i15 >> 8;
                                    allocate2.put((i82 * 3) + 1, (byte) (i83 & 255));
                                    allocate2.put((i82 * 3) + 2, (byte) ((i83 >> 8) & 255));
                                    int i84 = i81 + 1;
                                    if (i84 == i) {
                                        i84 = 0;
                                    }
                                    i82++;
                                    i81 = i84;
                                }
                                i14 = i82;
                                break;
                            default:
                                i14 = i56;
                                break;
                        }
                    }
                    if (!z3) {
                        if (z4) {
                            if (((i51 * i5) / i4) + 2.0d > i42 + i54) {
                                allocate2.position(0);
                                allocate2.limit(i3 * i * i54);
                                a(outputStream, allocate2);
                                i18 = i42 + i54;
                                z2 = z3;
                                i19 = i47;
                            } else {
                                allocate2.position(0);
                                int floor = (int) (i3 * i * ((Math.floor((i51 * i5) / i4) + 2.0d) - i42));
                                if (floor > 0) {
                                    allocate2.limit(floor);
                                    a(outputStream, allocate2);
                                }
                            }
                        } else {
                            allocate2.position(0);
                            allocate2.limit(i3 * i * i54);
                            a(outputStream, allocate2);
                            i18 = i42 + i54;
                            z2 = z3;
                            i19 = i47;
                        }
                        i20 = (i74 - 1) / (i11 / i24);
                        if (i20 > i38) {
                            i20 = i38;
                        }
                        for (i21 = 0; i21 < i; i21++) {
                            System.arraycopy(dArr8[i21], i20, dArr8[i21], 0, ((i10 + 1) + i38) - i20);
                        }
                        int i85 = i74 - (i20 * (i11 / i24));
                        for (i22 = 0; i22 < i; i22++) {
                            System.arraycopy(dArr7[i22], i38, dArr8[i22], i10 + 1, i38);
                        }
                        int i86 = i45 + 1;
                        if ((i45 & 7) != 7) {
                            l(i51 / i6);
                        }
                        i47 = i19;
                        i42 = i18;
                        z3 = z2;
                        i45 = i86;
                        i39 = i53;
                        i43 = i54;
                        i44 = i55;
                        i48 = i51;
                        byteBuffer = wrap;
                        int i87 = i14;
                        i40 = i85;
                        i46 = i87;
                    } else {
                        if (i54 < i47) {
                            i19 = i47 - i54;
                            i18 = i42;
                            z2 = z3;
                        } else if (z4) {
                            if (((i51 * i5) / i4) + 2.0d > (i42 + i54) - i47) {
                                allocate2.position(i3 * i * i47);
                                allocate2.limit(i3 * i * (i54 - i47));
                                a(outputStream, allocate2);
                                i18 = (i54 - i47) + i42;
                                z2 = z3;
                                i19 = i47;
                            } else {
                                allocate2.position(i3 * i * i47);
                                allocate2.limit((int) (i3 * i * ((((Math.floor((i51 * i5) / i4) + 2.0d) + i42) + i54) - i47)));
                                a(outputStream, allocate2);
                            }
                        } else {
                            allocate2.position(i3 * i * i47);
                            allocate2.limit(i3 * i * i54);
                            a(outputStream, allocate2);
                            z2 = false;
                            i18 = (i54 - i47) + i42;
                            i19 = i47;
                        }
                        i20 = (i74 - 1) / (i11 / i24);
                        if (i20 > i38) {
                        }
                        while (i21 < i) {
                        }
                        int i852 = i74 - (i20 * (i11 / i24));
                        while (i22 < i) {
                        }
                        int i862 = i45 + 1;
                        if ((i45 & 7) != 7) {
                        }
                        i47 = i19;
                        i42 = i18;
                        z3 = z2;
                        i45 = i862;
                        i39 = i53;
                        i43 = i54;
                        i44 = i55;
                        i48 = i51;
                        byteBuffer = wrap;
                        int i872 = i14;
                        i40 = i852;
                        i46 = i872;
                    }
                }
            }
        }
    }

    public double a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, double d, int i4, boolean z, int i5) throws IOException {
        ByteBuffer byteBuffer;
        double[] dArr = {0.0d};
        int i6 = 0;
        bIz();
        ByteBuffer byteBuffer2 = null;
        if (z) {
            byteBuffer2 = ByteBuffer.allocate(8);
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        int i7 = 0;
        while (i7 < i4 * i) {
            double d2 = 0.0d;
            switch (i2) {
                case 1:
                    allocate.position(0);
                    allocate.limit(1);
                    byte[] bArr = new byte[allocate.limit()];
                    inputStream.read(bArr);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.position(wrap.limit());
                    wrap.flip();
                    d2 = 0.007874015748031496d * (wrap.get(0) - 128);
                    byteBuffer = wrap;
                    break;
                case 2:
                    allocate.position(0);
                    allocate.limit(2);
                    byte[] bArr2 = new byte[allocate.limit()];
                    inputStream.read(bArr2);
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
                    wrap2.position(wrap2.limit());
                    wrap2.flip();
                    d2 = wrap2.order(this.hCG).asShortBuffer().get(0) * 3.051850947599719E-5d;
                    byteBuffer = wrap2;
                    break;
                case 3:
                    allocate.position(0);
                    allocate.limit(3);
                    byte[] bArr3 = new byte[allocate.limit()];
                    inputStream.read(bArr3);
                    ByteBuffer wrap3 = ByteBuffer.wrap(bArr3);
                    wrap3.position(wrap3.limit());
                    wrap3.flip();
                    d2 = 1.1920930376163766E-7d * (((wrap3.get(0) & 255) << 0) | ((wrap3.get(1) & 255) << 8) | ((wrap3.get(2) & 255) << 16));
                    byteBuffer = wrap3;
                    break;
                case 4:
                    allocate.position(0);
                    allocate.limit(4);
                    byte[] bArr4 = new byte[allocate.limit()];
                    inputStream.read(bArr4);
                    ByteBuffer wrap4 = ByteBuffer.wrap(bArr4);
                    wrap4.position(wrap4.limit());
                    wrap4.flip();
                    d2 = wrap4.order(this.hCG).asIntBuffer().get(0) * 4.656612875245797E-10d;
                    byteBuffer = wrap4;
                    break;
                default:
                    byteBuffer = allocate;
                    break;
            }
            if (inputStream.available() != 0) {
                double d3 = d2 * d;
                if (!z) {
                    switch (i3) {
                        case 1:
                            double d4 = 127.0d * d3;
                            int a = i5 != 0 ? a(d4, dArr, i5, i6) : i(d4);
                            byteBuffer.position(0);
                            byteBuffer.limit(1);
                            byteBuffer.put(0, (byte) (a + 128));
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                        case 2:
                            double d5 = 32767.0d * d3;
                            int a2 = i5 != 0 ? a(d5, dArr, i5, i6) : i(d5);
                            byteBuffer.position(0);
                            byteBuffer.limit(2);
                            byteBuffer.asShortBuffer().put(0, (short) a2);
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                        case 3:
                            double d6 = 8388607.0d * d3;
                            int a3 = i5 != 0 ? a(d6, dArr, i5, i6) : i(d6);
                            byteBuffer.position(0);
                            byteBuffer.limit(3);
                            byteBuffer.put(0, (byte) (a3 & 255));
                            int i8 = a3 >> 8;
                            byteBuffer.put(1, (byte) (i8 & 255));
                            byteBuffer.put(2, (byte) ((i8 >> 8) & 255));
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                    }
                } else {
                    double d7 = d3 > 0.0d ? d3 : -d3;
                    if (dArr[0] >= d7) {
                        d7 = dArr[0];
                    }
                    dArr[0] = d7;
                    byteBuffer2.position(0);
                    byteBuffer2.putDouble(d3);
                    byteBuffer2.flip();
                    a(outputStream, byteBuffer2);
                }
                int i9 = i6 + 1;
                if (i9 == i) {
                    i9 = 0;
                }
                int i10 = i7 + 1;
                if ((262143 & i10) == 0) {
                    l(i10 / (i4 * i));
                }
                i7 = i10;
                i6 = i9;
                allocate = byteBuffer;
            } else {
                l(1.0d);
                return dArr[0];
            }
        }
        l(1.0d);
        return dArr[0];
    }

    public j() {
        this.hCG = ByteOrder.LITTLE_ENDIAN;
        this.hCH = new k();
        this.hCI = 150.0d;
        this.hCJ = 200.0d;
        this.hCK = 1;
        this.hCW = false;
    }

    public j(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, int i6, double d, int i7, boolean z) throws Exception {
        int i8;
        int i9;
        this.hCG = ByteOrder.LITTLE_ENDIAN;
        this.hCH = new k();
        this.hCI = 150.0d;
        this.hCJ = 200.0d;
        this.hCK = 1;
        this.hCW = false;
        double[] dArr = {0.0d};
        if (i7 < 0 || i7 > 4) {
            throw new IllegalArgumentException("unrecognized dither type : " + i7);
        }
        this.hCW = z;
        if (!this.hCW) {
            System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
        }
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
        }
        if (i4 == -1) {
            i8 = i3 != 1 ? i3 : 2;
            if (i8 == 4) {
                i8 = 3;
            }
        } else {
            i8 = i4;
        }
        int i10 = i2 == -1 ? i : i2;
        if (i7 != -1) {
            i9 = i7;
        } else if (i8 < i3) {
            if (i8 == 1) {
                i9 = 4;
            } else {
                i9 = 3;
            }
        } else {
            i9 = 1;
        }
        if (!this.hCW) {
            String[] strArr = {"none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)"};
            String[] strArr2 = {"rectangular", "triangular", "gaussian"};
            System.err.printf("frequency : %d -> %d\n", Integer.valueOf(i), Integer.valueOf(i10));
            System.err.printf("attenuation : %gdB\n", Double.valueOf(d));
            System.err.printf("bits per sample : %d -> %d\n", Integer.valueOf(i3 * 8), Integer.valueOf(i8 * 8));
            System.err.printf("nchannels : %d\n", Integer.valueOf(i5));
            System.err.printf("length : %d bytes, %g secs\n", Integer.valueOf(i6), Double.valueOf(((i6 / i3) / i5) / i));
            if (i9 == 0) {
                System.err.printf("dither type : none\n", new Object[0]);
            } else {
                System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", strArr[i9], strArr2[0], Double.valueOf(0.18d));
            }
            System.err.printf("\n", new Object[0]);
        }
        if (i9 != 0) {
            int i11 = 0;
            int i12 = 0;
            if (i8 == 1) {
                i11 = -128;
                i12 = 127;
            }
            if (i8 == 2) {
                i11 = -32768;
                i12 = 32767;
            }
            if (i8 == 3) {
                i11 = -8388608;
                i12 = 8388607;
            }
            if (i8 == 4) {
                i11 = Integer.MIN_VALUE;
                i12 = Integer.MAX_VALUE;
            }
            a(i10, i5, i11, i12, i9, 0, 0.18d);
        }
        if (i < i10) {
            dArr[0] = a(inputStream, outputStream, i5, i3, i8, i, i10, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        } else if (i > i10) {
            dArr[0] = b(inputStream, outputStream, i5, i3, i8, i, i10, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        } else {
            dArr[0] = a(inputStream, outputStream, i5, i3, i8, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        }
        if (!this.hCW) {
            System.err.printf("\n", new Object[0]);
        }
        if (i9 != 0) {
            yo(i5);
        }
        if (dArr[0] > 1.0d && !this.hCW) {
            System.err.printf("clipping detected : %gdB\n", Double.valueOf(20.0d * Math.log10(dArr[0])));
        }
    }

    protected byte[] d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.limit() - byteBuffer.position()];
        byteBuffer.get(bArr, 0, bArr.length);
        return bArr;
    }

    protected void a(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(d(byteBuffer));
        } catch (IOException e) {
        }
    }
}
